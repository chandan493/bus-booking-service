package com.bookingservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bookingservice.model.UserDetails;

@Repository("userDetailsDao")
public class UserDetailsDaoImpl implements UserDetailsDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserDetails registerUser(UserDetails userDetails) {
		entityManager.persist(userDetails);
		return userDetails;
	}

	@Override
	public boolean removeUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDetails getUserDetailsByEmailId(String userEmailId) {
		Query query=entityManager.createQuery("SELECT ud FROM UserDetails ud where ud.userEmail=:userEmail");
		query.setParameter("userEmail", userEmailId);
		return (UserDetails) query.getSingleResult();
	}

}
