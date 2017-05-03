package com.bookingservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.dao.UserDetailsDao;
import com.bookingservice.model.UserDetails;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Override
	public UserDetails registerUser(UserDetails userDetails) {
		if(userDetailsDao.getUserDetailsByEmailId(userDetails.getUserEmail())==null){
			return userDetailsDao.registerUser(userDetails);
		}else{
			return null;
		}
		
	}

	@Override
	public boolean removeUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

}
