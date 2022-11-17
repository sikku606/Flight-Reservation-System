//package com.airline.service;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.airline.model.User;
//import com.airline.repository.UserRepo;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//	private UserRepo userRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepo.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getUserPassword(),
//				Arrays.asList(new SimpleGrantedAuthority("USER")));
//	}
//}