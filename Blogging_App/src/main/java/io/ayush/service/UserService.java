package io.ayush.service;

import java.util.List;

import io.ayush.payload.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

}


