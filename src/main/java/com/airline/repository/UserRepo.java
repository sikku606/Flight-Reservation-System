package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.dto.UserDto;
import com.airline.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);

	UserDto save(UserDto newUser);

}