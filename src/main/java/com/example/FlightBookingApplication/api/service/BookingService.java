package com.example.FlightBookingApplication.api.service;

import java.util.List;

import com.example.FlightBookingApplication.api.models.Booking;
import com.example.FlightBookingApplication.api.models.FareType;
import com.example.FlightBookingApplication.api.models.Flight;
import com.example.FlightBookingApplication.api.models.Seat;
import com.example.FlightBookingApplication.api.models.Users;
import com.example.FlightBookingApplication.api.repository.FlightRepository;
import com.example.FlightBookingApplication.api.repository.UserRepository;

public class BookingService {

	public static String bookFlight(String userId, String flightNumber, int departDate, FareType fareType,
			List<Seat> seats) {
		Users user = UserRepository.getInstance().getUserById(userId);
		Flight flight = findFlight(flightNumber, departDate);

		if (flight == null) {
			throw new IllegalArgumentException("Invalid flight details.");
		}

		if (user == null) {
			throw new IllegalArgumentException("Invalid user details.");
		}

		double totalCost = calculateTotalCost(seats, fareType);

		if (user.getFunds() < totalCost) {
			throw new IllegalStateException("Insufficient funds to book the flight.");
		}

		for (Seat seat : seats) {
			if (seat.isBooked()) {
				throw new IllegalStateException("Seat " + seat.getSeatNumber() + " is already booked.");
			}
		}

		user.setFunds(user.getFunds() - totalCost);

		for (Seat seat : seats) {
			seat.bookSeat();
		}

		return new Booking(userId, flightNumber, departDate, fareType, seats).getBookingId();
	}

	private static double calculateTotalCost(List<Seat> seats, FareType fareType) {
		double totalCost = 0.0;

		for (Seat seat : seats) {
			totalCost += fareType.getPrice();
		}

		return totalCost;
	}

	private static Flight findFlight(String flightNumber, int departDate) {
		List<Flight> flights = FlightRepository.getInstance().getAllFlights();
		for (Flight flight : flights) {
			if (flight.getFlightNumber().equals(flightNumber) && flight.getDepartDate() == departDate) {
				return flight;
			}
		}
		return null;
	}

}
