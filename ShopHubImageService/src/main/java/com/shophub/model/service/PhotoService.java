package com.shophub.model.service;

import com.shophub.model.collections.Photo;
import com.shophub.model.config.ImageUtil;
import com.shophub.model.repository.PhotoRepository;
import com.shophub.model.to.ImageRequestTo;
import com.shophub.model.to.ImageResponseTo;
import com.shophub.model.to.PhotoTo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpStatus;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public String addPhoto(ImageRequestTo to) throws IOException {
        Photo photo = new Photo(to.getImage().getOriginalFilename());
        photo.setImage(new Binary(BsonBinarySubType.BINARY, ImageUtil.compressImage(to.getImage().getBytes())));
        photo.setName(to.getImage().getOriginalFilename());
        photo.setType(to.getImage().getContentType());
        photo.setCategory(to.getCategory());
        photo.setUrl(to.getUrl());
        photo = photoRepository.insert(photo);
        StringBuilder sb = new StringBuilder("/").append(to.getComponent()).append("/")
                .append(photo.getName());
        return sb.toString();
    }

    public byte[] getPhoto(final String url) {
        Optional<Photo> image = photoRepository.findByUrl(url);
        return image.map(o-> o.getImage().getData()).orElseThrow(RuntimeException::new);
    }

    public List<byte[]> getPhotos() {
        List<byte[]> photoList = new ArrayList<>();
        List<Photo> images = photoRepository.findAll();
        for (Photo image : images) {
            photoList.add(ImageUtil.decompressImage(image.getImage().getData()));
        }
        return photoList;
    }

    public List<PhotoTo> getPhotoInfos() {
        List<PhotoTo> photoList = new ArrayList<>();
        List<Photo> images = photoRepository.findAll();
        for (Photo image : images) {
            PhotoTo to = PhotoTo.builder().id(image.getId()).name(image.getName()).type(image.getType())
                    .title(image.getTitle()).build();
            photoList.add(to);
        }
        return photoList;
    }

    @Transactional
    public ImageResponseTo uploadImageFromUrl(String link) {
        try {
            String path = link;
            //URLDecoder.decode(link, StandardCharsets.UTF_8);
            URL url = new URL(path);
            byte[] image = convertImageToBytes(url);
            assert image != null;
            log.info(String.valueOf(image.length));
            Binary binary = new Binary(BsonBinarySubType.BINARY, image);
            String fileName = FilenameUtils.getName(path);
            photoRepository.save(Photo.builder().name(fileName).title(fileName)
                    .type(FilenameUtils.getExtension(path)).url(link).category(fileName).image(binary).build());
            log.info("Image uploaded from URL {}", link);
            return ImageResponseTo.builder().message("Image uploaded successfully: " + fileName)
                    .statusCode(HttpStatus.SC_OK).build();
        } catch (Exception e) {
            log.error("Error in image upload");
            return ImageResponseTo.builder().message(e.getLocalizedMessage())
                    .statusCode(HttpStatus.SC_OK).build();
        }
    }

    private byte[] convertImageToBytes(URL url) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        InputStream is = null;
        try {
            HttpURLConnection con = getHttpURLConnection(url);
            is = new BufferedInputStream(con.getInputStream());
            byte[] byteChunk = new byte[8182];
            int n;
            while ((n = is.read(byteChunk)) > 0) {
                bos.write(byteChunk, 0, n);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return null;
    }

    private static HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36");
        con.setRequestProperty("Accept-Encoding", "gzip, deflate, br, zstd");
        con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        con.setRequestMethod("GET");
        con.connect();
        return con;
    }

}
