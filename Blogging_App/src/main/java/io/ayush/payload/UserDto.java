package io.ayush.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
	
	private int id;

	@NotBlank
	@Size(min = 4, message = "Username must be min of 4 characters !!")
	private String name;

	@Email(message = "Email address is not valid !!")
	@NotBlank(message = "Email is required !!")
	private String email;

	@NotBlank
	@Size(min = 3, max = 10, message = "Password bvetween 3 - 10 characters !!")
	private String password;

	@NotBlank
	private String about;

}
