package com.airline.service;

import java.util.List;

import com.airline.dto.ScheduleDto;
import com.airline.model.Schedule;

public interface ScheduleService {

	ScheduleDto findByFlightId(Long flightId);


	
}
