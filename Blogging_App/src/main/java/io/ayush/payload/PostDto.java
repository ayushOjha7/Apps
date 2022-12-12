package io.ayush.payload;

import java.util.Date;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto { 
	
	private Integer postId;
	
	@Size(min = 2, message = "Post title should be between 4 - 10 characters")
	private String title;
	
	@Size(min = 2, message = "Post Content should be between 4 - 500 characters")
	private String content;
	
	private String imageName;

	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
//	private Set<CommentDto> comments=new HashSet<>();
}
