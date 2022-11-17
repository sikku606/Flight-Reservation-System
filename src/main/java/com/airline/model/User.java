package com.airline.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity(name = "user")
@Data
public class User extends BaseEntity {

	@Pattern(regexp = "[a-zA-Z]{4,10}", message = "Enter FirstName only in alphabets with min 4 alphabets and max 10!!")
	private String firstName;

	@Pattern(regexp = "[a-zA-Z]{0,10}", message = "Enter LastName only in alphabets with min 0 alphabets and max 10!!")
	private String lastName;

	@Pattern(regexp = "[a-zA-Z_0-9]+@[a-z]+[\\.][a-z]{2,3}")
	@Column(unique = true)
	private String email;

	@Pattern(regexp = "[A-Z][a-z]*[0-9][a-z]", message = "Password must contain one uppercase,lowercase and one number between lowercase !!")
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Booking> booking = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles;

}
