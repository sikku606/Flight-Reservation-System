//package com.airline.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.airline.dto.ScheduleDto;
//import com.airline.dto.UserDto;
//import com.airline.exception.RecordNotFoundException;
//import com.airline.model.Schedule;
//import com.airline.model.User;
//import com.airline.service.FlightService;
//import com.airline.service.ScheduleService;
//
//@RestController
//@RequestMapping("/schedule")
//public class ScheduleController {
//
//	@Autowired
//	private ScheduleService scheduleService;
//	/**
//	 * Add a Schedule
//	 * Service url:  /schedule method: POST
//	 * 
//	 * @param schedule
//	 * @return schedule
//	 * @throws new Schedule
//	 */
//	@PostMapping
//	public ResponseEntity<ScheduleDto> addSchedule( @RequestBody ScheduleDto scheduleDto) {
//		ScheduleDto schedule2 = scheduleService.addSchedule(scheduleDto);
//		return new ResponseEntity<ScheduleDto>(schedule2, HttpStatus.CREATED);
//	}
//
//	/**
//	 * Edit a schedule
//	 * Service url:  /schedule method: PUT
//	 * 
//	 * @param schedule
//	 * @return schedule
//	 * @throws updated Schedule
//	 */
//
//	@PutMapping("/{id}")
//	public ResponseEntity<Object> modifySchedule(@Valid @RequestBody ScheduleDto scheduleDto, @PathVariable Long scheduleId) {
//		return ResponseEntity.ok(scheduleService.modifySchedule(scheduleDto, scheduleId));
//	}
//	/**
//	 * Delete a schedule
//	 * Service url:  /schedule method: DELETE
//	 * @param flightId
//	 * @return 
//	 * @throws deleted Schedule
//	 */
//	@DeleteMapping("/{id}")
//	public ResponseEntity<ScheduleDto> removeSchedule(@PathVariable Long scheduleId) {
//		scheduleService.removeSchedule(scheduleId);
//		return new ResponseEntity<ScheduleDto>(HttpStatus.OK);
//	}
//	/**
//	 * Get specific flight by Id
//	 * Service url:  /schedule method: GET 
//	 * 
//	 * @param flightId
//	 * @return Schedule
//	 * @throws specific schedule
//	 */
//	@GetMapping
//	public ResponseEntity<List<ScheduleDto>> viewAllSchedule(ScheduleDto scheduleDto) {
//		return new ResponseEntity<List<ScheduleDto>>(HttpStatus.OK);
//	}
//	/**
//	 * Get list of All Schedules 
//	 * Service url: /schedule/ method: GET
//	 *@param bookingDate,source,destination
//	 * @return List of all schedule
//	 * @throws schedule list
//	 */
//	@GetMapping("/{source}{bookingDate}{destination}")
//	public List<ScheduleDto> viewAllSF( @PathVariable String bookingDate, @PathVariable String source, @PathVariable String destination) {
//		return scheduleService.viewAllSchedules(bookingDate, source, destination);
//	}
//	
//
//	
//}
