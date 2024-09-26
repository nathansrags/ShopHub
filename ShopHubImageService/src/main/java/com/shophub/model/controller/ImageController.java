package com.shophub.model.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shophub.model.service.PhotoService;
import com.shophub.model.to.ImageRequestTo;
import com.shophub.model.to.ImageResponseTo;
import com.shophub.model.to.PhotoTo;

import lombok.extern.slf4j.Slf4j;

@RestController("/api")
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
		log.info("Geting Photos ");
		List<byte[]> images = photoService.getPhotos();
		return ResponseEntity.status(HttpStatus.OK)
				.body(ImageResponseTo.builder().statusCode("OK").data(images).build());
	}

	@GetMapping(value = "/photos/info/")
	public ResponseEntity<ImageResponseTo> getInfos() {
		log.info("Geting Photos Info");
		List<PhotoTo> tos = photoService.getPhotoInfos();
		return ResponseEntity.status(HttpStatus.OK).body(ImageResponseTo.builder().statusCode("OK").data(tos).build());
	}
}
