package com.airline.service;

import java.util.List;

import javax.validation.Valid;

import com.airline.dto.BookingDto;

public interface BookingService {

	BookingDto createBooking(BookingDto bookingDto);

	BookingDto getBookingById(Long id);

	BookingDto updateBooking(@Valid BookingDto updateBooking, Long id);

	List<BookingDto> getAllBookings();

	void deleteBooking(Long id);

}
