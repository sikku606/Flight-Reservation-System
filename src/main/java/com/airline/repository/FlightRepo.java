package com.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.dto.FlightDto;
import com.airline.model.Flight;

public interface FlightRepo extends JpaRepository<Flight , Integer> {

	Flight findById(Long id);
	
	Flight findByFlightNo(String flightNo);

//	List<FlightDto> findBySourceAndDestination(String source, String destination);
	
	
}
