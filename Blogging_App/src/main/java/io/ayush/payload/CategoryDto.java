package io.ayush.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	@NotBlank
	@Size(min = 4, max = 10, message = "Category title should be between 4 - 10 characters long")
	private String categoryTitle;

	@NotBlank
	@Size(min = 10,max = 100, message = "Description should be between 10 - 100 characters long")
	private String categoryDescription;

}
