package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.model.Flight;

public interface FlightRepo extends JpaRepository<Flight , Integer> {

	Flight findById(Long id);
	

}
