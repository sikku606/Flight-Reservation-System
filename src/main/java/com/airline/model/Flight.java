package com.airline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.aspectj.weaver.NewConstructorTypeMunger;

import lombok.Data;

@Data
@Entity
public class Flight extends BaseEntity {

	@Column(name = "flightNo")
	private String flightNo;

	@Column(name = "flightName")
	private String flightName;


	@Column(name = "luggageCapacity")
	private int luggageCapacity;

	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
	private List<Schedule> schedules = new ArrayList<>();

	
}
