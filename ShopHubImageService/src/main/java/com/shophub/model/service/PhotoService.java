package com.shophub.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shophub.model.collections.Photo;
import com.shophub.model.config.ImageUtil;
import com.shophub.model.repository.PhotoRepository;
import com.shophub.model.to.ImageRequestTo;
import com.shophub.model.to.PhotoTo;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepository photoRepository;

	public String addPhoto(ImageRequestTo to) throws IOException {
		Photo photo = new Photo(to.getImage().getOriginalFilename());
		photo.setImage(new Binary(BsonBinarySubType.BINARY, ImageUtil.compressImage(to.getImage().getBytes())));
		photo.setName(to.getImage().getOriginalFilename());
		photo.setType(to.getImage().getContentType());
		photo.setComponent(to.getComponent());
		photo.setScreen(to.getScreen());
		photo = photoRepository.insert(photo);
		StringBuilder sb = new StringBuilder(to.getScreen()).append("/").append(to.getComponent()).append("/")
				.append(photo.getName());
		return sb.toString();
	}

	public byte[] getPhoto(final String id) {
		Photo image = photoRepository.findByName(id).get();
		return ImageUtil.decompressImage(image.getImage().getData());
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

}
