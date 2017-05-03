package com.bookingservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.model.ResponseEntity;
import com.bookingservice.model.UserBookingDetails;
import com.bookingservice.model.UserDetails;
import com.bookingservice.service.UserBookingDetailsService;
import com.bookingservice.service.UserService;

/**
 * Class UserController
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserBookingDetailsService userBookingDetailsService;
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity registerUser(@RequestBody UserDetails userDetails) {
		ResponseEntity responseEntity = new ResponseEntity();
		Map<String, Object> userMap = new HashMap<>();
		UserDetails ud = userService.registerUser(userDetails);
		if (null == ud) {
			userMap.put("result", "Registration failed. Email id already exists.");
		} else {
			userMap.put("result", ud);
		}
		responseEntity.setResult(userMap);
		return responseEntity;
	}
	
	@RequestMapping(value = "/bookingDetails", method = RequestMethod.POST)
	public ResponseEntity getBookingDetails(@RequestBody UserDetails userDetails) {
		ResponseEntity responseEntity = new ResponseEntity();
		Map<String, Object> userMap = new HashMap<>();
		List<UserBookingDetails> userBookingDetails=userBookingDetailsService.getUserBookignDetailsByEmailId(userDetails.getUserEmail());
		if(userBookingDetails.size()==0){
			userMap.put("result", "not booking found for the user "+userDetails.getUserEmail());
		}else{
			userMap.put("result", userBookingDetails);
		}
		responseEntity.setResult(userMap);
		return responseEntity;
	}

}
