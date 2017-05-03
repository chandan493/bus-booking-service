package com.bookingservice.dao;

import com.bookingservice.model.UserDetails;

public interface UserDetailsDao {

	 UserDetails registerUser(UserDetails userDetails);
	 boolean removeUser(UserDetails userDetails);
	 UserDetails getUserDetailsByEmailId(String userEmailId);
}
