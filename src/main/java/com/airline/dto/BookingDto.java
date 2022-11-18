package com.airline.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.airline.model.Flight;
import com.airline.model.Schedule;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BookingDto {

	@Pattern(regexp="[a-zA-Z]{3,15}", message = "Source shouldn't be less than 3 and more than 15 characters !!")  
	private String source;

	@Pattern(regexp="[a-zA-Z]{3,15}", message = "Destination shouldn't be less than 3 and more than 15 characters !!")   
	private String destination;
	
	private Date departureDate;

	private Date arrivalDate;

	private String flightNo;

	@Min(value = 1)
	@Max(value = 6)
	private int noOfseat;
	



}
