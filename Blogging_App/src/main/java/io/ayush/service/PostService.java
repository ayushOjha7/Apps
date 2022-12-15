package io.ayush.service;

import java.util.List;

import io.ayush.payload.PostDto;
import io.ayush.payload.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	PostDto getPostById(Integer postId);

	List<PostDto> getAllPostByCategory(Integer categoryId);

	List<PostDto> getAllPostByUser(Integer userId);

	List<PostDto> searchPost(String Keyword);

}
