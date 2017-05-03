package com.bookingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.dao.UserBookingDetailsDao;
import com.bookingservice.model.UserBookingDetails;

@Service("userBookingDetailsService")
public class UserBookingDetailsServiceImpl implements UserBookingDetailsService {

	@Autowired
	UserBookingDetailsDao userBookingDetailsDao;
	
	@Override
	public boolean bookBus(UserBookingDetails bookingDetails) {
		return userBookingDetailsDao.bookBus(bookingDetails);
	}

	@Override
	public List<UserBookingDetails> getUserBookignDetailsByEmailId(String userEmailId) {
		return userBookingDetailsDao.getUserBookingDetailsByEmailId(userEmailId);
	}

}
