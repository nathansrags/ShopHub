package com.shophub.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shophub.model.collections.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String>{
	
	
	Optional<Photo> findByName(String name);
	

}
