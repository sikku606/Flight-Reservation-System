package com.airline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.dto.BookingDto;
import com.airline.dto.UserDto;
import com.airline.model.Booking;
import com.airline.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	/**
	 * Add a Booking Service url: /booking method: POST
	 * 
	 * @param booking
	 * @return booking
	 * @throws new Booking
	 */
	@PostMapping
	public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingDto bookingDto) {
		BookingDto booking2 = bookingService.createBooking(bookingDto );
		return new ResponseEntity<BookingDto>(booking2, HttpStatus.CREATED);
	}
	/**
	 * Get list of All Bookings Service url: /booking method: GET
	 *
	 * @return List of all booking
	 * @throws Booking list
	 */

	@GetMapping
	public ResponseEntity<List<BookingDto>> getAllBooking() {
		List<BookingDto> booking  = bookingService.getAllBookings();
		return new ResponseEntity<List<BookingDto>>(booking, HttpStatus.OK);
	}
	

	/**
	 * Edit a booking
	 * Service url:  /booking method: PUT
	 * 
	 * @param booking
	 * @return booking
	 * @throws updated Booking
	 */

	@PutMapping("/{id}")
	public ResponseEntity<BookingDto> updateBooking(@Valid @RequestBody BookingDto bookingDto, @PathVariable Long id) {
		return ResponseEntity.ok(bookingService.updateBooking(bookingDto, id));
	}
	/**
	 * Get specific booking by ID Service url: /booking method: GET
	 * 
	 * @param id
	 * @return Booking
	 * @throws specific booking
	 */

	@GetMapping("/{id}")
	public BookingDto searchBookingByID(@PathVariable("id") Long id) {
		return bookingService.getBookingById(id);
	}
	/**
	 * Delete a booking Service url: / booking method: DELETE
	 * 
	 * @param id
	 * @return
	 * @throws deleted Booking
	 */

	@DeleteMapping("/{id}")
	public void deleteBooking(@PathVariable("id") Long id) {
		bookingService.deleteBooking(id);
	}
	
	
	@PostMapping("/{bookingId}")
	public String cancelBooking(@PathVariable Long bookingId) {
		return bookingService.cancelBooking(bookingId);
		
	}
}
