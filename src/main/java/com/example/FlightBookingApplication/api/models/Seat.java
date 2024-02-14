package com.example.FlightBookingApplication.api.models;

public class Seat {
	private String seatNumber;
	private boolean isBooked;

	public Seat() {
		super();
	}

	public Seat(String seatNumber) {
		this.seatNumber = seatNumber;
		this.isBooked = false;
	}

	public void bookSeat() {
		if (isBooked) {
			throw new IllegalStateException("Seat " + seatNumber + " is already booked.");
		}
		isBooked = true;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public boolean isBooked() {
		return isBooked;
	}
}
