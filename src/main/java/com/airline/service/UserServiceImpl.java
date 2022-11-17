package com.airline.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.airline.dto.UserDto;
import com.airline.exception.RecordAlreadyPresentException;
import com.airline.exception.RecordNotFoundException;
import com.airline.model.User;
import com.airline.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	// dto to user
	private User dtoToEntity(UserDto dto) {
		User user = new User();
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		return user;
	}

	public List<User> DtoToEntity(List<UserDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	// user to dto
	private UserDto entityToDto(User user) {

		UserDto dto = new UserDto();
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		return dto;
	}

	public List<UserDto> entityToDto(List<User> user) {
		return user.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	/**
	 * add User.
	 * 
	 * @param UserDto
	 * @return UserDto
	 * @see com.airline.dto.UserDto
	 */

	@Override
	public UserDto createUser(UserDto userDto) {

		User storedUserEmail = userRepo.findByEmail(userDto.getEmail());
		if (storedUserEmail == null) {
			User user = new User();
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setEmail(userDto.getEmail());
			user.setPassword(userDto.getPassword());

			return this.entityToDto(userRepo.save(user));
		} else {
			throw new RecordAlreadyPresentException("Email already exists !!");
		}
	}

	/**
	 * return all Users
	 * 
	 * @return list of UserDtos
	 * 
	 * @see com.airline.dto.UserDto
	 */

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
	}

	/**
	 * return User by id
	 * 
	 * @param id
	 * @return UserDto by id
	 * 
	 */
	@Override
	public UserDto getUserById(Long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("User", "User id", id));
		return entityToDto(user);
	}

	/**
	 * delete User by id
	 * 
	 * @param id
	 */
	@Override
	public void deleteUser(Long id) {
		User user = this.userRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("User", "User id", id));
		this.userRepo.delete(user);
	}

	/**
	 * update User
	 * 
	 * @param id
	 * @return updated User object
	 * @see com.airline.dto.UserDto
	 */

	@SuppressWarnings("deprecation")
	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		User user2 = this.userRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("User", "User id", id));

		if (!StringUtils.isEmpty(userDto.getFirstName())) {
			user2.setFirstName(userDto.getFirstName());
		}
		if (!StringUtils.isEmpty(userDto.getLastName())) {
			user2.setLastName(userDto.getLastName());
		}
		if (!StringUtils.isEmpty(userDto.getEmail())) {
			user2.setEmail(userDto.getEmail());
		}
		if (!StringUtils.isEmpty(userDto.getPassword())) {
			user2.setPassword(userDto.getPassword());
		}
		user2 = userRepo.save(user2);
		return entityToDto(user2);
	}
}
