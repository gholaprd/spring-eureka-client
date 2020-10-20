package com.rd;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FlightFiegnController {

	@Autowired
	private FlightClient client;
	
	@GetMapping("getAllFlights")
	public List<FlightDetails> getFlightDetails(){
		return client.getFlightDetails();
	}
	
	@GetMapping("getFlightDetailsById")
	public FlightDetails getFlightDetailsById(@RequestParam("flightMasterId") int flightMasterId){
		return client.findFlightByMasterId(flightMasterId);
	}
	@PostMapping(value = "/createFlight", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<FlightDetails> createFlight(@RequestBody FlightDetails flightDetails) {

		ResponseEntity<FlightDetails> save = client.createFlight(flightDetails);
		return save;

	}
}
