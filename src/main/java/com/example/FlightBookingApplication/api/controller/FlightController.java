package com.example.FlightBookingApplication.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FlightBookingApplication.api.models.BookingRequest;
import com.example.FlightBookingApplication.api.models.Flight;
import com.example.FlightBookingApplication.api.models.FlightInfo;
import com.example.FlightBookingApplication.api.service.BookingService;
import com.example.FlightBookingApplication.api.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

	@PostMapping("/book")
	public String bookFlight(@RequestBody BookingRequest bookingRequest) {
		return BookingService.bookFlight(bookingRequest.getUserId(), bookingRequest.getFlightNumber(),
				bookingRequest.getDepartDate(), bookingRequest.getFareType(), bookingRequest.getSeats());
	}

	@GetMapping("/search")
	public List<FlightInfo> searchFlights(@RequestParam String from, @RequestParam String to,
			@RequestParam int departDate, @RequestParam int paxCount) {
		return FlightService.searchFlight(from, to, departDate, paxCount);
	}

	@GetMapping("/searchByPreference")
	public List<FlightInfo> searchFlights(@RequestParam String from, @RequestParam String to,
			@RequestParam int departDate, @RequestParam int paxCount,
			@RequestParam(required = false) String preferredAirline, @RequestParam(required = false) String sortBy,
			@RequestParam(required = false, defaultValue = "asc") String sortType) {
		return FlightService.searchFlightByPreference(from, to, departDate, paxCount, preferredAirline, sortBy,
				sortType);
	}

}
