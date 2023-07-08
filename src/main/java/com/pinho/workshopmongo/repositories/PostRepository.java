package com.pinho.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pinho.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query(" { 'title': { $regex: ?0, $options: 'i' } } ")
	List<Post> searchTitle(String text);
}