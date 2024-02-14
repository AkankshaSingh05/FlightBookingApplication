package com.example.FlightBookingApplication.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.FlightBookingApplication.api.models.FareType;
import com.example.FlightBookingApplication.api.models.Flight;
import com.example.FlightBookingApplication.api.models.Seat;

public class FlightRepository {

	private static final FlightRepository instance = new FlightRepository();

	public static FlightRepository getInstance() {
		return instance;
	}

	private final List<Flight> flightList;

	private FlightRepository() {
		flightList = new ArrayList<>();

		List<FareType> seatsByFareType1 = new ArrayList<>();
		seatsByFareType1.add(new FareType("F1", 2000, createSeats("1b", "2c", "4e")));
		addFlight(new Flight("123", "6E", "DEL", "BLR", 2, 10, 11, seatsByFareType1));

		List<FareType> seatsByFareType2 = new ArrayList<>();
		seatsByFareType2.add(new FareType("F2", 4000, createSeats("4e")));
		addFlight(new Flight("156", "6E", "DEL", "BLR", 2, 14, 15, seatsByFareType2));

		List<FareType> seatsByFareType3 = new ArrayList<>();
		seatsByFareType3.add(new FareType("F3", 1000, createSeats("29a", "40e", "1e", "4e")));
		addFlight(new Flight("234", "6E", "DEL", "HYD", 2, 15, 16, seatsByFareType3));

		List<FareType> seatsByFareType4 = new ArrayList<>();
		seatsByFareType4.add(
				new FareType("F5", 10000, createSeats("7c", "7d", "12c", "5f", "8e", "7e", "4d", "3e", "4a", "10a")));
		addFlight(new Flight("456", "6E", "AMD", "CCU", 2, 18, 22, seatsByFareType4));

		List<FareType> seatsByFareType5 = new ArrayList<>();
		seatsByFareType5.add(new FareType("F11", 2500, createSeats("12c", "5f", "4d", "3e", "4a", "10a")));
		addFlight(new Flight("987", "SJ", "DEL", "BLR", 2, 11, 16, seatsByFareType5));

		List<FareType> seatsByFareType6 = new ArrayList<>();
		seatsByFareType6.add(new FareType("F1", 2300, createSeats("8e", "7e", "4d", "6a", "15a")));
		addFlight(new Flight("1001", "SJ", "DEL", "HYD", 2, 9, 12, seatsByFareType6));

		List<FareType> seatsByFareType7 = new ArrayList<>();
		seatsByFareType7.add(new FareType("F2", 2100, createSeats("45e", "30a", "1e", "4e", "7c", "7d", "12c")));
		addFlight(new Flight("890", "SJ", "DEL", "AMD", 2, 12, 18, seatsByFareType7));

		List<FareType> seatsByFareType8 = new ArrayList<>();
		seatsByFareType8.add(new FareType("F1d", 2900,
				createSeats("1e", "4e", "7c", "7d", "12c", "5f", "8e", "7e", "4d", "3e", "4a", "10a")));
		addFlight(new Flight("999", "SJ", "DEL", "HYD", 2, 8, 12, seatsByFareType8));

		List<FareType> seatsByFareType9 = new ArrayList<>();
		seatsByFareType9
				.add(new FareType("F1x", 2000, createSeats("5a", "10b", "34e", "20c", "20a", "8b", "8a", "9b")));
		addFlight(new Flight("432", "UK", "DEL", "BLR", 2, 16, 18, seatsByFareType9));

		List<FareType> seatsByFareType10 = new ArrayList<>();
		seatsByFareType10.add(new FareType("F1d", 4300, createSeats("12a", "13b")));
		addFlight(new Flight("444", "UK", "BLR", "DEL", 2, 11, 13, seatsByFareType10));

		List<FareType> seatsByFareType11 = new ArrayList<>();
		seatsByFareType11.add(new FareType("F1", 2800, createSeats("5a", "10b", "34e", "20c", "3e", "4a", "10a")));
		addFlight(new Flight("456", "UK", "DEL", "BLR", 2, 19, 21, seatsByFareType11));

		List<FareType> seatsByFareType12 = new ArrayList<>();
		seatsByFareType12.add(new FareType("F1", 3600, createSeats("41a", "44b", "44c", "12d")));
		addFlight(new Flight("654", "AI", "DEL", "BLR", 2, 21, 23, seatsByFareType12));

		List<FareType> seatsByFareType13 = new ArrayList<>();
		seatsByFareType13.add(new FareType("F1", 6700,
				createSeats("20c", "20a", "8b", "8a", "9b", "10c", "21a", "18b", "18a", "19b")));
		addFlight(new Flight("236", "AI", "DEL", "BLR", 2, 17, 19, seatsByFareType13));

		List<FareType> seatsByFareType14 = new ArrayList<>();
		seatsByFareType14.add(new FareType("F1", 1500, createSeats("1a", "1b", "1c", "1d")));
		addFlight(new Flight("980", "QP", "DEL", "BLR", 2, 13, 14, seatsByFareType14));

		List<FareType> seatsByFareType15 = new ArrayList<>();
		seatsByFareType15.add(new FareType("F11", 2100, createSeats("3b", "12c")));
		addFlight(new Flight("123", "6E", "DEL", "BLR", 2, 10, 11, seatsByFareType15));
	}

	public void addFlight(Flight newFlight) {
		Flight existingFlight = getFlightByAttributes(newFlight);

		if (existingFlight != null) {
			updateExistingFlight(existingFlight, newFlight);
		} else {
			flightList.add(newFlight);
		}
	}

	private Flight getFlightByAttributes(Flight newFlight) {
		return flightList.stream()
				.filter(flight -> flight.getFlightNumber().equals(newFlight.getFlightNumber())
						&& flight.getAirline().equals(newFlight.getAirline())
						&& flight.getFrom().equalsIgnoreCase(newFlight.getFrom())
						&& flight.getTo().equalsIgnoreCase(newFlight.getTo())
						&& flight.getDepartDate() == (newFlight.getDepartDate())
						&& flight.getDepartTime() >= (newFlight.getDepartTime())
						&& flight.getDepartTime() <= (newFlight.getArrivalTime()))
				.findFirst().orElse(null);
	}

	private void updateExistingFlight(Flight existingFlight, Flight newFlight) {
		for (FareType newFareType : newFlight.getFaretypes()) {
			updateOrAddFareType(existingFlight, newFareType);
		}
	}

	private void updateOrAddFareType(Flight existingFlight, FareType newFareType) {
		Optional<FareType> existingFareType = existingFlight.getFaretypes().stream()
				.filter(ft -> ft.getName().equals(newFareType.getName())).findFirst();

		if (existingFareType.isPresent()) {
			for (Seat newSeat : newFareType.getSeats()) {
				if (!existingFareType.get().getSeats().contains(newSeat)) {
					existingFareType.get().getSeats().add(newSeat);
				}
			}
		} else {
			existingFlight.getFaretypes().add(newFareType);
		}
	}

	private List<Seat> createSeats(String... seatNumbers) {
		List<Seat> seats = new ArrayList<>();
		for (String seatNumber : seatNumbers) {
			seats.add(new Seat(seatNumber));
		}
		return seats;
	}

	public List<Flight> getAllFlights() {
		return new ArrayList<>(flightList);
	}

	public Flight getFlightByFlightNumber(final String flightNumber) {
		return flightList.stream().filter(flight -> flight.getFlightNumber().equals(flightNumber)).findFirst()
				.orElse(null);
	}
}