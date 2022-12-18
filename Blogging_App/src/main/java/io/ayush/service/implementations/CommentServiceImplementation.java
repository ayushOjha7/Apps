package io.ayush.service.implementations;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ayush.entities.Comment;
import io.ayush.entities.Post;
import io.ayush.exceptions.ResourceNotFoundException;
import io.ayush.payload.CommentDto;
import io.ayush.repositories.CommentRepository;
import io.ayush.repositories.PostRepository;
import io.ayush.service.CommentService;

@Service
public class CommentServiceImplementation implements CommentService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepository.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	@Transactional
	public void deleteComment(Integer commentId) {

		this.commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));
		
		this.commentRepository.deleteComment(commentId);
	}

}
