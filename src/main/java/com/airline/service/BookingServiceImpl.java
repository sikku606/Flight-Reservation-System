package com.airline.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.airline.dto.BookingDto;
import com.airline.dto.ScheduleDto;
import com.airline.exception.RecordNotFoundException;
import com.airline.model.Booking;
import com.airline.model.Flight;
import com.airline.model.Schedule;
import com.airline.repository.BookingRepo;
import com.airline.repository.FlightRepo;
import com.airline.repository.ScheduleRepo;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo bookingRepo;

	@Autowired
	private ScheduleRepo scheduleRepo;

	@Autowired
	private FlightRepo flightRepo;

	/**
	 * add booking.
	 * 
	 * @param BookingDto
	 * @return bookingDto
	 * @see com.airline.dto.BookingDto
	 */

	@Override
	public BookingDto createBooking(BookingDto bookingDto) {
		Booking booking = this.dtoToEntity(bookingDto);
		Flight flight = flightRepo.findByFlightNo(booking.getFlightNo());
		Schedule schedule = scheduleRepo.findByFlightId(flight.getId());
		schedule.setAvailableSeat(schedule.getTotalSeat() - booking.getNoOfseat());
		scheduleRepo.save(schedule);
		Booking saveBooking = this.bookingRepo.save(booking);

		return this.entityToDto(saveBooking);

	}

	/**
	 * return all Bookings
	 * 
	 * @return list of BookingDtos
	 * 
	 * @see com.airline.dto.BookingDto
	 */

	// dto to user
	private Booking dtoToEntity(BookingDto dto) {
		Booking booking = new Booking();
		booking.setSource(dto.getSource());
		booking.setDestination(dto.getDestination());
		booking.setArrivalDate(dto.getArrivalDate());
		booking.setDepartureDate(dto.getDepartureDate());
		booking.setFlightNo(dto.getFlightNo());
		booking.setNoOfseat(dto.getNoOfseat());
		return booking;
	}

	public List<Booking> DtoToEntity(List<BookingDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	// user to dto
	private BookingDto entityToDto(Booking booking) {

		BookingDto dto = new BookingDto();
		dto.setSource(booking.getSource());
		dto.setDestination(booking.getDestination());
		dto.setArrivalDate(booking.getArrivalDate());
		dto.setDepartureDate(booking.getDepartureDate());
		dto.setFlightNo(booking.getFlightNo());
		dto.setNoOfseat(booking.getNoOfseat());
		return dto;
	}

	public List<BookingDto> entityToDto(List<Booking> booking) {
		return booking.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	/**
	 * Show the details of a booking identifiable by the id.
	 */

	@Override
	public BookingDto getBookingById(Long id) {
		Booking booking = bookingRepo.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Booking", "Booking id", id));
		return entityToDto(booking);
	}

	/**
	 * delete Booking by id
	 * 
	 * @param id
	 */
	@Override
	public void deleteBooking(Long id) {
		Booking booking = this.bookingRepo.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("User", "User id", id));
		this.bookingRepo.delete(booking);
	}

	/**
	 * update Booking
	 * 
	 * @param id
	 * @return updated Booking object
	 * @see com.restaurant.dto.BookingDto
	 */
	@SuppressWarnings("deprecation")
	@Override
	public BookingDto updateBooking(BookingDto bookingDto, Long id) {
		Booking booking2 = this.bookingRepo.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Booking", "Booking id", id));

		if (!StringUtils.isEmpty(bookingDto.getSource())) {
			booking2.setSource(bookingDto.getSource());
		}
		if (!StringUtils.isEmpty(bookingDto.getDestination())) {
			booking2.setDestination(bookingDto.getDestination());
		}
		if (!StringUtils.isEmpty(bookingDto.getDepartureDate())) {
			booking2.setDepartureDate(bookingDto.getDepartureDate());
		}
		if (!StringUtils.isEmpty(bookingDto.getArrivalDate())) {
			booking2.setArrivalDate(bookingDto.getArrivalDate());
		}
		if (!StringUtils.isEmpty(bookingDto.getFlightNo())) {
			booking2.setFlightNo(bookingDto.getFlightNo());
		}
		if (!StringUtils.isEmpty(bookingDto.getNoOfseat())) {
			booking2.setNoOfseat(bookingDto.getNoOfseat());
		}

		booking2 = bookingRepo.save(booking2);
		return entityToDto(booking2);
	}

	@Override
	public List<BookingDto> getAllBookings() {
		List<Booking> bookings = bookingRepo.findAll();
		return bookings.stream().map(booking -> entityToDto(booking)).collect(Collectors.toList());

	}

	@Override
	public String cancelBooking(Long bookingId) {
		return "Booking Cancelled";
	}
}
