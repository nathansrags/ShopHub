package com.shophub.model.controller;

import com.shophub.model.service.PhotoService;
import com.shophub.model.to.ImageRequestTo;
import com.shophub.model.to.ImageResponseTo;
import com.shophub.model.to.PhotoTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 *
 */
@RestController("/api/v2")
@Slf4j
public class ImageController {

    private final PhotoService photoService;

    public ImageController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping(value = "/photos/add")
    public String addPhoto(@RequestPart MultipartFile file, @RequestParam ImageRequestTo imageData)
            throws IOException {
        imageData.setImage(file);
        String id = photoService.addPhoto(imageData);
        return "redirect:/photos/" + id;
    }

    @GetMapping(value = "/photos/{url}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPhoto(@RequestParam("url") String url) {
        try {
            byte[] image = photoService.getPhoto(url);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(image);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getLocalizedMessage());
        }
    }

    @GetMapping(value = "/photos/")
    public ResponseEntity<List<ImageResponseTo>> getPhotos() {
        log.info("Getting Photos ");
        List<ImageResponseTo> images = photoService.getPhotos();
        return ResponseEntity.status(HttpStatus.OK)
                .body(images);
    }

    @GetMapping(value = "/photos/info/")
    public ResponseEntity<List<PhotoTo>> getInfos() {
        log.info("Getting Photos Info");
        List<PhotoTo> tos = photoService.getPhotoInfos();
        return ResponseEntity.status(HttpStatus.OK).body(tos);
    }

    @GetMapping(value = "/by/" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageResponseTo> saveImageFromUrl(@RequestParam("url") String url) {
        return ResponseEntity.status(HttpStatus.OK).body(photoService.uploadImageFromUrl(url));
    }
}
