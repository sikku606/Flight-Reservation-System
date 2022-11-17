package com.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.dto.BookingDto;
import com.airline.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

	void deleteById(String bookingId);

	Optional<BookingDto> findById(String bookingId);

}
