package com.rd;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@RestController
public class ClientFlightController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("getAllFlights")
	public List<FlightDetails> getFlightDetails(){
		String url= "http://SPRING-DATA-JPA-REGISTRATION/getAllFlightDetails";
		List forObject = restTemplate.getForObject(url, List.class);
		System.out.println(forObject);
		return forObject;
		
	}
	
}
