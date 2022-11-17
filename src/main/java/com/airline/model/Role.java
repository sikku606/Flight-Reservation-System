package com.airline.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Role extends BaseEntity {

	 
	 private String roleName;
	 
	 @ManyToMany(mappedBy = "roles")
	    private Set<User> users;
}
