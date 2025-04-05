package com.shophub.model.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequestTo {
	
	String title;
	String category;
	@JsonIgnore
	String url;
	String component;
	MultipartFile image;
	

}
