package com.shophub.model.controller;

import com.shophub.model.service.PhotoService;
import com.shophub.model.to.ImageRequestTo;
import com.shophub.model.to.ImageResponseTo;
import com.shophub.model.to.PhotoTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController("/api/v2")
@Slf4j
public class ImageController {

    @Autowired
    private PhotoService photoService;

    @PostMapping(value = "/photos/add")
    public String addPhoto(@RequestPart MultipartFile file, @RequestParam ImageRequestTo imagedata)
            throws IOException {
        imagedata.setImage(file);
        String id = photoService.addPhoto(imagedata);
        return "redirect:/photos/" + id;
    }

    @GetMapping(value = "/photos/{id}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable String id) {
        byte[] image = photoService.getPhoto(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(image);
    }

    @GetMapping(value = "/photos/")
    public ResponseEntity<ImageResponseTo> getPhotos() {
        log.info("Getting Photos ");
        List<byte[]> images = photoService.getPhotos();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ImageResponseTo.builder().statusCode(org.apache.http.HttpStatus.SC_OK).data(images).build());
    }

    @GetMapping(value = "/photos/info/")
    public ResponseEntity<ImageResponseTo> getInfos() {
        log.info("Getting Photos Info");
        List<PhotoTo> tos = photoService.getPhotoInfos();
        return ResponseEntity.status(HttpStatus.OK).body(ImageResponseTo.builder()
                .statusCode(org.apache.http.HttpStatus.SC_OK).data(tos).build());
    }

    @PostMapping
    public ImageResponseTo saveImageFromUrl(@RequestParam String url) {
        return photoService.uploadImageFromUrl(url);
    }
}
