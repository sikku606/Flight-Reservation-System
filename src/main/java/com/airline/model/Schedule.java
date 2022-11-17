package com.airline.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
	
	

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "departureDate")
	private Date departureDate;

	@Column(name = "arrivalDate")
	private Date arrivalDate;

	@Column(name = "availableSeat")
	private int availableSeat;

	@Column(name = "totalSeat")
	private int totalSeat;

	@ManyToOne
	private Flight flight;

}
