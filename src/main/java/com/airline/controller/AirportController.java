//package com.airline.controller;
//
//import java.util.List;
//import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.airline.dto.AirportDto;
//import com.airline.dto.ApiResponse;
//import com.airline.service.AirportService;
//
//@RestController
//@RequestMapping("/airport")
//public class AirportController {
//
//	@Autowired
//	private AirportService airportService;
//
//	/**
//	 * get detail of Airport by id
//	 * Service url: /airport/id
//	 * method: GET
//	 *@param id
//	 * @return AirportDto of particular id
//	 * @see com.airline.dto.AirportDto
//	 */
//	@GetMapping("/{id}")
//	public AirportDto getAirportById(@PathVariable("id") int airportId) {
//		return airportService.getAirportById(airportId);
//	}
//	
//	/**
//	 * get list of Airport
//	 * Service url: /airport
//	 * method :  GET
//	 * @return list of AirportDto {@link com.airline.dto.AirportDto}
//	 */
//	@GetMapping
//	public ResponseEntity<List<AirportDto>> getAllAirports() {
//		List<AirportDto> airportDto = airportService.getAllAirports();
//		return new ResponseEntity<>(airportDto, HttpStatus.OK);
//	}
//
//	/**
//	 * Add Airport
//	 * service url : /airport
//	 * method : Post
//	 * @param AirportDto
//	 * @return AirportDto {@link com.airline.dto.AirportDto}
//	 */
//	@PostMapping("/{id}")
//	public ResponseEntity<AirportDto> createAirport(@Valid @RequestBody AirportDto airportDto, @PathVariable long id) {
//		AirportDto newAirport = airportService.createAirport(airportDto,id);
//		return new ResponseEntity<>(newAirport, HttpStatus.CREATED);
//	}
//	/**
//	 * Update Airport by id
//	 * service url: /airport/id
//	 * method : PUT
//	 * @param id
//	 * @param AirportDto
//	 * @return Updated AirportDto {@link com.airline.dto.AirportDto}
//	 */
//	@PutMapping("/{id}")
//	public ResponseEntity<AirportDto> updateAirport(@RequestBody AirportDto airportDto, @PathVariable long id) {
//		AirportDto updateAirport = this.airportService.updateAirport(airportDto, id);
//		return new ResponseEntity<>(updateAirport, HttpStatus.OK);
//	}
//
//	/**
//	 * Delete Airport by id
//	 * Method : DELETE
//	 * Service url: /airport/id
//	 * @param id
//	 * 
//	 */
//	@DeleteMapping("/{id}")
//	public ResponseEntity<ApiResponse> deleteAirport(@PathVariable long id){
//		this.airportService.deleteAirport(id);
//		return new ResponseEntity<>(new ApiResponse("Rating delete successfully",true),HttpStatus.OK);
//	}
//	}
//
//
