package com.shophub.model.collections;

import javax.validation.constraints.NotNull;

import org.bson.types.Binary;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Document(collection = "ComponentImages")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EnableMongoAuditing
public class Photo {
	@Version
	private Long photoId;
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
	private String url;
	@Field
	@NotNull
	private String category;
	@Field
	@NotNull
	private String product;
	@Field
	@NotNull
	private Binary image;

	public Photo(String originalFilename) {
		this.name = name;
	}

	@CreatedDate

	public boolean isNew(String name) {
		return name == null;
	}

}
