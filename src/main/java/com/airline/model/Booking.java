package com.airline.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Booking extends BaseEntity {

	@Pattern(regexp = "[a-zA-Z]{3,15}", message = "Source shouldn't be less than 3 !! ")
	private String source;

	@Pattern(regexp = "[a-zA-Z]{3,15}", message = "Source shouldn't be less than 3 !! ")
	private String destination;

	private Date departureDate;

	private Date arrivalDate;

	private String flightNo;

	@Min(value = 1, message = "Please choose seat not less than 1 !!")
	@Max(value = 6, message = "Please choose seat not more than 6 !!")
	private int noOfseat;

	
	@ManyToOne
	private User user;

}
