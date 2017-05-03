package com.bookingservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookingservice.model.BusDetails;
import com.bookingservice.model.UserBookingDetails;

@Repository("userBookingDetailsDao")
public class UserBookingDetailsDaoImpl implements UserBookingDetailsDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	BusDetailsDao busDetailsDao;
	
	@Override
	public boolean bookBus(UserBookingDetails bookingDetails) {
		
		BusDetails busDetails=busDetailsDao.getBusDetailsByBusId(bookingDetails.getBusId());
		if(busDetails!=null && busDetails.getNoOfSeat()>bookingDetails.getSeats()){
			entityManager.persist(bookingDetails);
			busDetails.setNoOfSeat(busDetails.getNoOfSeat()-bookingDetails.getSeats());
			busDetailsDao.updateBusSeats(busDetails);
			return true;
		}else{
			System.out.println("No of seats requested are not available");
		}
		return false;
	}

	@Override
	public List<UserBookingDetails> getUserBookingDetailsByEmailId(String userEmailId) {
		Query query=entityManager.createQuery("SELECT bd FROM UserBookingDetails bd where bd.userEmailId=:userEmailId");
		query.setParameter("userEmailId", userEmailId);
		return query.getResultList();
	}

}
