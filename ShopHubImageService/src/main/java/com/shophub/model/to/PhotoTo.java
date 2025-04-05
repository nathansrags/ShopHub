package com.shophub.model.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoTo {
	private String id;
	private String title;
	private String name;
	private String type;
	private String url;
	private String category;
	private byte[] image;
}
