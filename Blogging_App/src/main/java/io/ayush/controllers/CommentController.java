package io.ayush.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ayush.payload.ApiResponse;
import io.ayush.payload.CommentDto;
import io.ayush.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	private CommentService CommentService;

	@PostMapping("post/{postId}/comments")
	ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId) {

		CommentDto savedCommentDto = this.CommentService.createComment(commentDto, postId);

		return new ResponseEntity<CommentDto>(savedCommentDto, HttpStatus.CREATED);
	}

	@DeleteMapping("comments/{commentId}")
	ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {

		this.CommentService.deleteComment(commentId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Deleted Successfully", true), HttpStatus.OK);
	}

}
