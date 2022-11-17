package com.airline.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.airline.model.Flight;

import lombok.Data;

@Data
public class ScheduleDto {

	private String source;

	private String destination;

	private Date departureDate;

	private Date arrivalDate;

	private int availableSeat;

	private int totalSeat;
	
}
