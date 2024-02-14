package com.example.FlightBookingApplication.api.models;

import java.util.List;

public class FlightInfo {

	private String flightNumber;
	private String airline;
	private String from;
	private String to;
	private int departDate;
	private int departTime;
	private double price;
	private String faretype;
	private List<Seat> seats;

	public FlightInfo() {
	}

	public FlightInfo(String flightNumber, String airline, String from, String to, int departDate, int departTime,
			double price, String faretype, List<Seat> seats) {
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.from = from;
		this.to = to;
		this.departDate = departDate;
		this.departTime = departTime;
		this.price = price;
		this.faretype = faretype;
		this.seats = seats;
	}

	public String getAirline() {
		return airline;
	}

	public int getDepartDate() {
		return departDate;
	}

	public int getDepartTime() {
		return departTime;
	}

	public String getFaretype() {
		return faretype;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getFrom() {
		return from;
	}

	public double getPrice() {
		return price;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public String getTo() {
		return to;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setDepartDate(int departDate) {
		this.departDate = departDate;
	}

	public void setDepartTime(int departTime) {
		this.departTime = departTime;
	}

	public void setFaretype(String faretype) {
		this.faretype = faretype;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
