package com.airline.service;

import java.util.List;
import javax.validation.Valid;
import com.airline.dto.UserDto;

public interface UserService {

	List<UserDto> getAllUsers();

	UserDto updateUser(@Valid UserDto userDto, Long id);

	UserDto createUser(UserDto userDto);

	UserDto getUserById(Long id);

	void deleteUser(Long id);
	


	

	
	
	



	

	
}
