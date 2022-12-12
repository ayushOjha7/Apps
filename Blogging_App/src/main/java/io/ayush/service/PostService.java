package io.ayush.service;

import java.util.List;

import io.ayush.payload.PostDto;

public interface PostService {
	
	  PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	  
	  PostDto updatePost(PostDto postDto, Integer postId);
	  
	  void deletePost(Integer postId);
	  
	  PostDto getPostById(Integer postId);
	  
	  List<PostDto> getAllPostByCategory(Integer categoryId);
	    
	  List<PostDto> getAllPostByUser(Integer userId);
	  
	  List<PostDto> searchPost(String Keyword);

}
