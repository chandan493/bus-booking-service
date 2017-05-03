package com.bookingservice.service;

import java.util.List;

import com.bookingservice.model.BusDetails;

public interface BusDetailsService {
	List<BusDetails> getBusDetailsByOriginDestinationAndDate(String origin,String destination,String date,int noOfSeat);
	BusDetails saveBusDetails(BusDetails busDetails);
	BusDetails getBusDetailsById(long id);
	
}
