package com.example.FlightBookingApplication.api.models;

import java.util.List;
import java.util.UUID;

public class Booking {

	private String bookingId;
	private String userId;

	private String flightNumber;

	private int departDate;

	private FareType fareType;

	private List<Seat> seats;

	public Booking(String userId, String flightNumber, int departDate, FareType fareType, List<Seat> seats) {
		this.bookingId = UUID.randomUUID().toString();
		this.userId = userId;
		this.flightNumber = flightNumber;
		this.departDate = departDate;
		this.fareType = fareType;
		this.seats = seats;
	}

	public String getBookingId() {
		return bookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getDepartDate() {
		return departDate;
	}

	public void setDepartDate(int departDate) {
		this.departDate = departDate;
	}

	public FareType getFareType() {
		return fareType;
	}

	public void setFareType(FareType fareType) {
		this.fareType = fareType;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

}
