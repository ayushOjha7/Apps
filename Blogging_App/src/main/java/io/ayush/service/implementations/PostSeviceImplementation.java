package io.ayush.service.implementations;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.ayush.entities.Category;
import io.ayush.entities.Post;
import io.ayush.entities.User;
import io.ayush.exceptions.ResourceNotFoundException;
import io.ayush.payload.PostDto;
import io.ayush.repositories.CategoryRepository;
import io.ayush.repositories.PostRepository;
import io.ayush.repositories.UserRepository;
import io.ayush.service.PostService;

@Service
public class PostSeviceImplementation implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id : ", userId));
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id : ", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);

		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);

		Post savedPost = this.postRepository.save(post);
		return this.modelMapper.map(savedPost, PostDto.class);

	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {

		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

		Category category = this.categoryRepository.findById(postDto.getCategory().getCategoryId()).get();

		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		post.setCategory(category);

		Post updatedPost = this.postRepository.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);

	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

		this.postRepository.delete(post);

	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPostByCategory(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
		List<Post> posts = this.postRepository.findByCategory(category);

		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postDtos;
	}

	@Override
	public List<PostDto> getAllPostByUser(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User ", "userId ", userId));
		List<Post> posts = this.postRepository.findByUser(user);

		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postDtos;
	}

	@Override
	public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber, pageSize);

		Page<Post> pagePost = this.postRepository.findAll(p);

		List<Post> allPost = pagePost.getContent();

		List<PostDto> postDtos = allPost.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
//        List<Post> posts = this.postRepository.searchByTitle("%" + keyword + "%");
//        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
//        return postDtos;

		return null;
	}

}
