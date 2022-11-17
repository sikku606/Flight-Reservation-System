package com.airline.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class FlightDto {

	private String flightNo;

	private String flightName;

	private int seatCapacity;

	private int luggageCapacity;
	
	@OneToMany
	private List<ScheduleDto> schedules ;
}
