package com.airline.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserDto {

	@Pattern(regexp = "[a-zA-Z]{4,10}", message = "Enter FirstName only in alphabets with min 4 alphabets and max 10!!")
	private String firstName;

	@Pattern(regexp = "[a-zA-Z]{0,10}", message = "Enter LastName only in alphabets with min 0 alphabets and max 10!!")
	private String lastName;

	@Pattern(regexp = "[a-zA-Z_0-9]+@[a-z]+[\\.][a-z]{2,3}" , message = "Please follow the same as given : e.g. user@yahoo.in")
	private String email;

	@Pattern(regexp = "[A-Z][a-z]*[0-9][a-z]", message = "Password must contain one uppercase,lowercase and one number between lowercase !!")
	private String password;

}
