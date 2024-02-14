package com.example.FlightBookingApplication.api.models;

import java.util.List;

public class BookingRequest {
	private String userId;
	private String flightNumber;
	private int departDate;
	private FareType fareType;
	private List<Seat> seats;

	public int getDepartDate() {
		return departDate;
	}

	public FareType getFareType() {
		return fareType;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public String getUserId() {
		return userId;
	}

	public void setDepartDate(int departDate) {
		this.departDate = departDate;
	}

	public void setFareType(FareType fareType) {
		this.fareType = fareType;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
