//package com.airline.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.airline.dto.AirportDto;
//import com.airline.dto.UserDto;
//import com.airline.exception.RecordNotFoundException;
//import com.airline.model.Airport;
//import com.airline.model.User;
//import com.airline.repository.AirportRepo;
//
//@Service
//public class AirportServiceImpl implements AirportService {
//	
//	@Autowired
//	private AirportRepo airportRepo;
//	
//	// dto to airport
//		private Airport dtoToEntity( AirportDto dto) {
//			Airport airport = new Airport();
//			airport.setAirportName(dto.getAirportName());
//			return airport;
//		}
//
//		public List<Airport> DtoToEntity(List<AirportDto> dto){
//			return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
//		}
//		
//		// airport to dto
//		private AirportDto entityToDto(Airport airport) {
//			AirportDto dto = new AirportDto();
//			dto.setAirportName(airport.getAirportName());
//			return dto;
//		}
//		
//		public List<AirportDto> entityToDto(List<Airport> airport){
//			return airport.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
//		}
//		
//		/**
//		 * return Airport by id
//		 * 
//		 * @param id
//		 * @return AirportDto by id
//		 * 
//		 */
//
//		@Override
//		public AirportDto getAirportById(long id) {
//			Airport airport = this.airportRepo.findById(id)
//					.orElseThrow(() -> new RecordNotFoundException("Airport", "Airport id", id));
//			return entityToDto(airport);
//		}
//		
//		/**
//		 * delete Airport
//		 * @param id
//		 * @return void
//		 */
//		@Override
//		public void deleteAirport(long id) {
//			Airport airport = this.airportRepo.findById(id)
//					.orElseThrow(() -> new RecordNotFoundException("Airport", "Airport id", id));
//			this.airportRepo.delete(airport);
//		}
//		
//		/**
//		 * add Airport.
//		 * @param AirportDto
//		 * @return AirportDto
//		 * @see com.airline.dto.AirportDto
//		 */
//		@Override
//		public AirportDto createAirport(AirportDto airportDto, long id) {
//			Airport airport = airportRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("Airport", "Airport id", id));
//			return this.entityToDto(airport);
//		}
//		/**
//		 * update Airport
//		 * 
//		 * @param id
//		 * @return updated Airport object
//		 * @see com.airline.dto.AirportDto
//		 */
//		@Override
//		public AirportDto updateAirport(AirportDto airportDto, long id) {
//		Airport airport = this.airportRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("Airport", "Airport id", id));
//			airport.setAirportName(airportDto.getAirportName());
//			return this.entityToDto(airport);		
//		}
//
//		/**
//		 * return all Airports
//		 * 
//		 * @return list of AirportDtos
//		 * 
//		 * @see com.airline.dto.AirportDto
//		 */
//		@Override
//		public List<AirportDto> getAllAirports() {
//			List<Airport> airports = this.airportRepo.findAll();
//			List<AirportDto> airportDtos = airports.stream().map(airport -> entityToDto(airport)).collect(Collectors.toList());
//			return airportDtos;
//		}
//
//
//	
//
//	
//}
