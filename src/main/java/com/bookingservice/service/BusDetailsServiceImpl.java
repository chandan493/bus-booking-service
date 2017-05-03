package com.bookingservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.dao.BusDetailsDao;
import com.bookingservice.model.BusDetails;

@Service("busDetailsService")
@Transactional
public class BusDetailsServiceImpl implements BusDetailsService {

	@Autowired
	BusDetailsDao busDetailsDao;
	
	@Override
	public List<BusDetails> getBusDetailsByOriginDestinationAndDate(String origin, String destination, String date,
			int noOfSeat) {
		return busDetailsDao.getBusDetailsByOriginDestinationAndDate(origin, destination, date, noOfSeat);
	}

	@Override
	public BusDetails saveBusDetails(BusDetails busDetails) {
		return busDetailsDao.saveBusDetails(busDetails);
	}

	@Override
	public BusDetails getBusDetailsById(long id) {
		return busDetailsDao.getBusDetailsByBusId(id);
	}

}
