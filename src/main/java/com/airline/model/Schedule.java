package com.airline.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

	private String source;

	private String destination;

	private Date departureDate;

	private Date arrivalDate;

	private int availableSeat;

	private int totalSeat;

	@ManyToOne
	private Flight flight;
	
	
	


}
