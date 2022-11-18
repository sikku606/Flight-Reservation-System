package com.airline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.airline.dto.FlightDto;
import com.airline.dto.ScheduleDto;
import com.airline.dto.UserDto;
import com.airline.exception.RecordNotFoundException;
import com.airline.model.Flight;
import com.airline.model.Schedule;
import com.airline.model.User;
import com.airline.repository.FlightRepo;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepo flightRepo;

	// dto to schedule
	private Flight dtoToEntity(FlightDto dto) {
		Flight flight = new Flight();
		flight.setFlightNo(dto.getFlightNo());
		flight.setFlightName(dto.getFlightName());
		flight.setLuggageCapacity(dto.getLuggageCapacity());
		return flight;
	}

	public List<Flight> dtoToEntity(List<FlightDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	// schedule to dto
	private FlightDto entityToDto(Flight flight) {

		FlightDto dto = new FlightDto();
		dto.setFlightNo(flight.getFlightNo());
		dto.setFlightName(flight.getFlightName());
		dto.setLuggageCapacity(flight.getLuggageCapacity());
		List<ScheduleDto> scheduleItems = flight.getSchedules().stream().map(o -> {
			ScheduleDto scheduleItem = new ScheduleDto();
			scheduleItem.setArrivalDate(o.getArrivalDate());
			scheduleItem.setDepartureDate(o.getDepartureDate());
			scheduleItem.setSource(o.getSource());
			scheduleItem.setDestination(o.getDestination());
			scheduleItem.setTotalSeat(o.getTotalSeat());
			scheduleItem.setAvailableSeat(o.getAvailableSeat());
			
			return scheduleItem;

		}).collect(Collectors.toList());
		dto.setSchedules(scheduleItems);
		return dto;
	}

	public List<FlightDto> entityToDto(List<Flight> flight) {
		return flight.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	@Override
	public FlightDto addFlight(FlightDto flightDto) {
		Flight flight = this.dtoToEntity(flightDto);
		List<Schedule> scheduleItems = flightDto.getSchedules().stream().map(o -> {
			Schedule scheduleItem = new Schedule();
			scheduleItem.setArrivalDate(o.getArrivalDate());
			scheduleItem.setDepartureDate(o.getDepartureDate());
			scheduleItem.setSource(o.getSource());
			scheduleItem.setDestination(o.getDestination());
			scheduleItem.setTotalSeat(o.getTotalSeat());
			scheduleItem.setAvailableSeat(o.getAvailableSeat());
			scheduleItem.setFlight(flight);
			
			return scheduleItem;

		}).collect(Collectors.toList());
		flight.setSchedules(scheduleItems);

		return this.entityToDto(this.flightRepo.save(flight));
	}

	@Override
	public List<FlightDto> viewFlights() {
		List<Flight> flights = flightRepo.findAll();
		return flights.stream().map(flight -> entityToDto(flight)).collect(Collectors.toList());
	}

	@SuppressWarnings("deprecation")
	@Override
	public FlightDto modifyFlight(FlightDto flightDto, Long id) {
		Flight flight2 = this.flightRepo.findById(id);

		if (!StringUtils.isEmpty(flightDto.getFlightNo())) {
			flight2.setFlightNo(flightDto.getFlightNo());
		}
		if (!StringUtils.isEmpty(flightDto.getFlightName())) {
			flight2.setFlightName(flightDto.getFlightName());
		}
		if (!StringUtils.isEmpty(flightDto.getLuggageCapacity())) {
			flight2.setLuggageCapacity(flightDto.getLuggageCapacity());
		}
		flight2 = flightRepo.save(flight2);
		return entityToDto(flight2);
	}

	@Override
	public void removeFlight(long id) {
		Flight flight = this.flightRepo.findById(id);
		this.flightRepo.delete(flight);
	}

	/**
	 * return Flight by id
	 * 
	 * @param id
	 * @return FlightDto by id
	 * 
	 */
	@Override
	public FlightDto getFlightById(Long id) {
		return entityToDto(flightRepo.findById(id));
	}

	@Override
	public List<FlightDto> viewAllFlights() {
		List<Flight> flights = flightRepo.findAll();
		return flights.stream().map(flight -> entityToDto(flight)).collect(Collectors.toList());
	}

	




}
