package com.bookingservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bookingservice.model.BusDetails;

@Repository("busDetailsDao")
public class BusDetailsDaoImpl implements BusDetailsDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public BusDetails saveBusDetails(BusDetails busDetails) {
		entityManager.persist(busDetails);
		return busDetails;
	}

	@Override
	public List<BusDetails> getBusDetailsByOriginDestinationAndDate(String origin, String destination, String date,
			int noOfSeat) {
		Query query = entityManager.createQuery(
				"SELECT bd FROM BusDetails bd WHERE bd.busOrigin = :busOrigin and bd.busDestination=:busDestination and bd.busDate=:busStartingDate and bd.noOfSeat > :noOfSeat");
		query.setParameter("busOrigin", origin);
		query.setParameter("busDestination", destination);
		query.setParameter("busStartingDate", date);
		query.setParameter("noOfSeat", noOfSeat);
		List<BusDetails> busDetails = query.getResultList();
		return busDetails;
	}

	@Override
	public BusDetails getBusDetailsByBusId(long id) {
		Query query = entityManager.createQuery("SELECT db FROM BusDetails db where db.busId=:busId");
		query.setParameter("busId", id);
		return (BusDetails) query.getSingleResult();
	}

	@Override
	public boolean updateBusSeats(BusDetails busDetails) {
		try {
			entityManager.merge(busDetails);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
