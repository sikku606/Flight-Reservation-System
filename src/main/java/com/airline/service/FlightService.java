package com.airline.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.airline.dto.FlightDto;
import com.airline.dto.UserDto;
import com.airline.model.Flight;

public interface FlightService {

	FlightDto addFlight(FlightDto flightDto);

	FlightDto modifyFlight(@Valid FlightDto flightDto, Long id);

	List<FlightDto> viewFlights();

	void removeFlight(long id);

	FlightDto getFlightById(Long id);

//	Flight findByFlightNo(String flightNo);

//	Flight saveFlight(Flight flight);
	




	
}
