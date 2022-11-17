package com.airline.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.dto.ScheduleDto;
import com.airline.model.Schedule;

public interface ScheduleRepo extends JpaRepository<Schedule , Long> {

	List<ScheduleDto> findByDepartureDateAndSourceAndDestination(String bookingDate, String source, String destination);

}
