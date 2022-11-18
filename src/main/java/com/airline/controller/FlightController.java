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

import com.airline.dto.FlightDto;
import com.airline.dto.ScheduleDto;
import com.airline.dto.UserDto;
import com.airline.model.Flight;
import com.airline.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService flightService;

	/**
	 * Add a Flight Service url: /user method: POST
	 * 
	 * @param flight
	 * @return flight
	 * @throws new Flight
	 */
	@PostMapping
	public ResponseEntity<FlightDto> addFlight(@Valid @RequestBody FlightDto flightDto) {
		FlightDto flight2 = flightService.addFlight(flightDto);
		return new ResponseEntity<FlightDto>(flight2, HttpStatus.CREATED);
	}

	/**
	 * Get list of All Flight url: /flight/ method: GET
	 * @return 
	 *
	 * @return List of all flight
	 * @throws Flight list
	 */

	@GetMapping
	public ResponseEntity<List<FlightDto>> viewAllFlight() {
		List<FlightDto> flight = flightService.viewAllFlights();
		return new ResponseEntity<List<FlightDto>>(flight, HttpStatus.OK);
	}

	/**
	 * Get specific flight by Id Service url: /flight method: GET
	 * 
	 * @param flightId
	 * @return Flight
	 * @throws specific flight
	 */

//	@GetMapping("/{source}{destination}")
//	public List<FlightDto> viewAllFlights( @PathVariable String source, @PathVariable String destination) {
//		return flightService.findBySourceAndDestination(source, destination);
//	}
	/**
	 * Edit a schedule Service url: /schedule method: PUT
	 * 
	 * @param schedule
	 * @return schedule
	 * @throws updated Schedule
	 */

	@PutMapping("/{id}")
	public ResponseEntity<FlightDto> modifyFlight(@Valid @RequestBody FlightDto flightDto, @PathVariable Long id) {
		return ResponseEntity.ok(flightService.modifyFlight(flightDto, id));
	}

	/**
	 * Delete a flight Service url: /flight method: DELETE
	 * 
	 * @param flightId
	 * @return
	 * @throws delete flight
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<FlightDto> removeFlight(@PathVariable Long id) {
		flightService.removeFlight(id);
		return new ResponseEntity<FlightDto>(HttpStatus.OK);
	}

}
