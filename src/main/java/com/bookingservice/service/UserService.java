package com.bookingservice.service;

import com.bookingservice.model.UserDetails;

public interface UserService {

	 UserDetails registerUser(UserDetails userDetails);
	 boolean removeUser(UserDetails userDetails);
	
}
