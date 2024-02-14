package com.example.FlightBookingApplication.api.models;

import java.util.List;

public class FareType {

	private String name;
	private double price;
	private List<Seat> seats;

	public FareType() {
		super();
	}

	public FareType(String name, double price, List<Seat> seats) {
		super();
		this.name = name;
		this.price = price;
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

}
