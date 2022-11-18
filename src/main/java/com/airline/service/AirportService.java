package com.airline.service;

import java.util.List;

import javax.validation.Valid;

import com.airline.dto.AirportDto;

public interface AirportService {

	AirportDto getAirportById(long id);

	List<AirportDto> getAllAirports();

	AirportDto createAirport(@Valid AirportDto airportDto, long id);

	AirportDto updateAirport(AirportDto airportDto, long id);

	void deleteAirport(long id);

	

}
