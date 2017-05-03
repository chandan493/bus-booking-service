package com.bookingservice.service;

import java.util.List;

import com.bookingservice.model.UserBookingDetails;

public interface UserBookingDetailsService {
	boolean bookBus(UserBookingDetails bookingDetails);
	List<UserBookingDetails> getUserBookignDetailsByEmailId(String userEmailId);
}
