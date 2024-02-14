package com.example.FlightBookingApplication.api.models;

import java.util.List;

public class Flight {
	private String flightNumber;
	private String airline;
	private String from;
	private String to;
	private int departDate;
	private int departTime;
	private int arrivalTime;
	private List<FareType> faretypes;

	public Flight(String flightNumber, String airline, String from, String to, int departDate, int departTime,
			int arrivalTime, List<FareType> faretypes) {
		super();
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.from = from;
		this.to = to;
		this.departDate = departDate;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.faretypes = faretypes;
	}

	public String getAirline() {
		return airline;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getDepartDate() {
		return departDate;
	}

	public int getDepartTime() {
		return departTime;
	}

	public List<FareType> getFaretypes() {
		return faretypes;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setDepartDate(int departDate) {
		this.departDate = departDate;
	}

	public void setDepartTime(int departTime) {
		this.departTime = departTime;
	}

	public void setFaretypes(List<FareType> faretypes) {
		this.faretypes = faretypes;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
