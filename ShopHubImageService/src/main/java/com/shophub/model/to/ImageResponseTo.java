package com.shophub.model.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageResponseTo {
	
	private int statusCode;
	private String message;
	private Object data;

}
