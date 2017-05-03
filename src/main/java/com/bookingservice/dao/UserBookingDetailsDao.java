package com.bookingservice.dao;

import java.util.List;

import com.bookingservice.model.UserBookingDetails;

public interface UserBookingDetailsDao {

	boolean bookBus(UserBookingDetails bookingDetails);
	List<UserBookingDetails> getUserBookingDetailsByEmailId(String userEmailId);
	
}
