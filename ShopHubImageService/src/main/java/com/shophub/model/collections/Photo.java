package com.shophub.model.collections;

import javax.validation.constraints.NotNull;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "ComponentImages")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Photo {

	@Id
	private String id;
	@Field
	@NotNull
	private String title;
	@Field
	@NotNull
	private String name;
	@Field
	@NotNull
	private String type;
	@Field
	@NotNull
	private String screen;
	@Field
	@NotNull
	private String component;
	@Field
	@NotNull
	private Binary image;

	public Photo(String name) {
		super();
		this.name = name;
	}

}
