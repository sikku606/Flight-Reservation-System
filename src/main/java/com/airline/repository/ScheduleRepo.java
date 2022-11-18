package com.airline.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.dto.FlightDto;
import com.airline.dto.ScheduleDto;
import com.airline.model.Schedule;

public interface ScheduleRepo extends JpaRepository<Schedule , Long> {


	Schedule findByFlightId(long flightId);

	ScheduleDto findBySource(String source);

}
