package com.bookingservice.dao;

import java.util.List;

import com.bookingservice.model.BusDetails;

public interface BusDetailsDao {

	List<BusDetails> getBusDetailsByOriginDestinationAndDate(String origin,String destination,String date,int noOfSeat);
	BusDetails saveBusDetails(BusDetails busDetails);
	BusDetails getBusDetailsByBusId(long id);
	boolean updateBusSeats(BusDetails busDetails);
	
}
