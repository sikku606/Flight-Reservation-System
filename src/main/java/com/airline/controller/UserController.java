package com.airline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.dto.UserDto;
import com.airline.model.User;
import com.airline.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Add a User Service url:/user method: POST
	 * 
	 * @param user
	 * @return user
	 * @throws new User
	 */

	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto user2 = userService.createUser(userDto);
		return new ResponseEntity<UserDto>(user2, HttpStatus.CREATED);
	}

	/**
	 * Get list of All Users Service url: /user/ method: GET
	 *
	 * @return List of all user
	 * @throws User list
	 */

	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<UserDto> user = userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(user, HttpStatus.OK);
	}

	/**
	 * Edit a user Service url: /user method: PUT
	 * 
	 * @param user
	 * @return user
	 * @throws updated User
	 */

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long id) {
		return ResponseEntity.ok(userService.updateUser(userDto, id));
	}

	/**
	 * Get specific user by Id Service url: /user method: GET
	 * 
	 * @param userId
	 * @return User
	 * @throws specific user
	 */

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	/**
	 * Delete a user Service url: /user method: DELETE
	 * 
	 * @param userId
	 * @return
	 * @throws deleted User
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<UserDto>(HttpStatus.OK);
	}

}
