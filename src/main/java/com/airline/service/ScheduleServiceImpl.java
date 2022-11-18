package com.airline.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.dto.ScheduleDto;
import com.airline.exception.RecordNotFoundException;
import com.airline.model.Schedule;
import com.airline.repository.ScheduleRepo;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepo scheduleRepo;

	@Override
	public ScheduleDto findByFlightId(Long flightId) {
		Schedule schedule = scheduleRepo.findByFlightId(flightId);
		return entityToDto(schedule);
	}

	// dto to user
	private Schedule dtoToEntity(ScheduleDto dto) {
		Schedule schedule = new Schedule();
		schedule.setSource(dto.getSource());
		schedule.setDestination(dto.getDestination());
		schedule.setArrivalDate(dto.getArrivalDate());
		schedule.setDepartureDate(dto.getDepartureDate());
		schedule.setAvailableSeat(dto.getAvailableSeat());
		schedule.setTotalSeat(dto.getTotalSeat());
		return schedule;
	}

	public List<Schedule> DtoToEntity(List<ScheduleDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	// user to dto
	private ScheduleDto entityToDto(Schedule schedule) {

		ScheduleDto dto = new ScheduleDto();
		dto.setSource(schedule.getSource());
		dto.setDestination(schedule.getDestination());
		dto.setArrivalDate(schedule.getArrivalDate());
		dto.setDepartureDate(schedule.getDepartureDate());
		dto.setAvailableSeat(schedule.getAvailableSeat());
		dto.setTotalSeat(schedule.getTotalSeat());
		return dto;
	}

	public List<ScheduleDto> entityToDto(List<Schedule> schedule) {
		return schedule.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

}
