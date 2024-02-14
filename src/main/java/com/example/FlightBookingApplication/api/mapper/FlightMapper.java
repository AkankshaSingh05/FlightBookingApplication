package com.example.FlightBookingApplication.api.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.FlightBookingApplication.api.models.FareType;
import com.example.FlightBookingApplication.api.models.Flight;
import com.example.FlightBookingApplication.api.models.FlightInfo;

public class FlightMapper {

	public static List<FlightInfo> mapFlightsToFlightInfo(List<Flight> flights) {
		List<FlightInfo> flightInfoList = new ArrayList<>();

		for (Flight flight : flights) {
			for (FareType fareType : flight.getFaretypes()) {

				FlightInfo flightInfo = new FlightInfo();
				flightInfo.setFlightNumber(flight.getFlightNumber());
				flightInfo.setAirline(flight.getAirline());
				flightInfo.setFrom(flight.getFrom());
				flightInfo.setTo(flight.getTo());
				flightInfo.setDepartDate(flight.getDepartDate());
				flightInfo.setDepartTime(flight.getDepartTime());
				flightInfo.setPrice(fareType.getPrice());
				flightInfo.setFaretype(fareType.getName());
				flightInfo.setSeats(fareType.getSeats());

				flightInfoList.add(flightInfo);
			}
		}

		return flightInfoList;
	}
}