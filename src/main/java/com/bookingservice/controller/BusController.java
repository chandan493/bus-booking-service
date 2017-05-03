package com.bookingservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.model.BusDetails;
import com.bookingservice.model.ResponseEntity;
import com.bookingservice.model.UserBookingDetails;
import com.bookingservice.service.BusDetailsService;
import com.bookingservice.service.UserBookingDetailsService;


@RestController
@RequestMapping(value="bus")
public class BusController {

	@Autowired
	BusDetailsService busDetailsService;
	@Autowired
	UserBookingDetailsService userBookingDetailsService;
	
	
	@RequestMapping(value="/bookBus",method=RequestMethod.POST)
	  public ResponseEntity registerUser(@RequestBody UserBookingDetails userBookingDetails) {
		  ResponseEntity responseEntity=new ResponseEntity();
		  Map<String,Object> busMap=new HashMap<>();
		  if(userBookingDetailsService.bookBus(userBookingDetails)){
			  busMap.put("result", "Booking Successful");
			  BusDetails tempBusDetails=busDetailsService.getBusDetailsById(userBookingDetails.getBusId());
			  tempBusDetails.setNoOfSeat(userBookingDetails.getSeats());
			  busMap.put("details",tempBusDetails);
		  }else{
			  busMap.put("result", "Booking failed for one or more reason");
		  }
		  
		  responseEntity.setResult(busMap);
		  return responseEntity;
	  }
	
	@RequestMapping(value="/addbus",method=RequestMethod.POST)
	  public ResponseEntity registerUser(@RequestBody BusDetails busDetails) {
		  ResponseEntity responseEntity=new ResponseEntity();
		  Map<String,BusDetails> busMap=new HashMap<>();
		  busMap.put("result", busDetailsService.saveBusDetails(busDetails));
		  responseEntity.setResult(busMap);
		  return responseEntity;
	  }
	  
	
  @RequestMapping(value="/search/{from}/{to}/{date}/{seat}",method=RequestMethod.GET)
  public ResponseEntity registerUser(@PathVariable("from") String origin,@PathVariable("to") String destination,@PathVariable("date") String journeyDate,@PathVariable("seat") int noOfSeat) {
	  ResponseEntity responseEntity=new ResponseEntity();
	  Map<String,Object> allResult=new HashMap<>();
	  List<BusDetails> busDetails=busDetailsService.getBusDetailsByOriginDestinationAndDate(origin, destination, journeyDate, noOfSeat);
	  if(busDetails.size()==0){
		  allResult.put("result", "no result found for the given criteria");
		  
	  }else{
		  allResult.put("result",busDetails);
	  }
	  responseEntity.setResult(allResult);
	  return responseEntity;
  }
  
  
  
} 
