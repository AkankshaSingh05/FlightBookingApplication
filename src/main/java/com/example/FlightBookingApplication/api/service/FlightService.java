package com.example.FlightBookingApplication.api.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.FlightBookingApplication.api.mapper.FlightMapper;
import com.example.FlightBookingApplication.api.models.FareType;
import com.example.FlightBookingApplication.api.models.Flight;
import com.example.FlightBookingApplication.api.models.FlightInfo;
import com.example.FlightBookingApplication.api.repository.FlightRepository;

public class FlightService {

	private static boolean isSeatsAvailable(Flight flight, int paxCount) {
		for (FareType faretype : flight.getFaretypes()) {
			long availableSeats = faretype.getSeats().stream().filter(seat -> !seat.isBooked()).count();

			if (availableSeats >= paxCount) {
				return true;
			}
		}

		return false;
	}

	public static List<FlightInfo> searchFlight(String from, String to, int departDate, int paxCount) {
		List<Flight> filteredFlights = FlightRepository.getInstance().getAllFlights().stream()
				.filter(flight -> flight.getFrom().equalsIgnoreCase(from))
				.filter(flight -> flight.getTo().equalsIgnoreCase(to))
				.filter(flight -> flight.getDepartDate() == departDate)
				.filter(flight -> isSeatsAvailable(flight, paxCount)).collect(Collectors.toList());

		return FlightMapper.mapFlightsToFlightInfo(filteredFlights);
	}

	public static List<FlightInfo> searchFlightByPreference(String from, String to, int departDate, int paxCount,
			String preferredAirline, String sortBy, final String sortType) {

		Comparator<FlightInfo> comparator;
		switch (sortBy.toLowerCase()) {
		case "departtime":
			comparator = Comparator.comparing(FlightInfo::getDepartTime);
			break;
		case "price":
			comparator = Comparator.comparing(FlightInfo::getPrice);
			break;
		default:
			comparator = Comparator.comparing(FlightInfo::getFlightNumber);
			break;
		}

		if ("desc".equalsIgnoreCase(sortType)) {
			comparator = comparator.reversed();
		}

		List<FlightInfo> filteredFlightInfoList = FlightRepository.getInstance().getAllFlights().stream()
				.filter(flight -> flight.getFrom().equalsIgnoreCase(from))
				.filter(flight -> flight.getTo().equalsIgnoreCase(to))
				.filter(flight -> flight.getDepartDate() == departDate)
				.filter(flight -> isSeatsAvailable(flight, paxCount))
				.filter(flight -> preferredAirline == null || flight.getAirline().equalsIgnoreCase(preferredAirline))
				.map(flight -> FlightMapper.mapFlightsToFlightInfo(Collections.singletonList(flight)))
				.flatMap(List::stream).sorted(comparator).collect(Collectors.toList());

		return filteredFlightInfoList;
	}

}
