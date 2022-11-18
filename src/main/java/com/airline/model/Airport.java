package com.airline.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Airport extends BaseEntity {

	@NotEmpty
	@Size(max = 50, message = "AirportName size not less then 20")
	private String airportName;

}
