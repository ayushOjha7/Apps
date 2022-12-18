package io.ayush.service;

import io.ayush.payload.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer commentId);

	void deleteComment(Integer commentId);

}
