package com.bookingservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "bus_details")
public class BusDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "BUS_ID")
	private long busId;

	@NotNull
	@Column(name = "BUS_ORIGIN")
	private String busOrigin;
	@NotNull
	@Column(name = "BUS_DESTINATION")
	private String busDestination;
	@NotNull
	@Column(name = "BUS_DATE")
	private String busDate;

	@NotNull
	@Column(name = "BUS_TOTAL_SEAT")
	private int noOfSeat;

	public int getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public long getBusId() {
		return busId;
	}

	public void setBusId(long busId) {
		this.busId = busId;
	}

	public String getBusOrigin() {
		return busOrigin;	
	}

	public void setBusOrigin(String busOrigin) {
		this.busOrigin = busOrigin;
	}

	public String getBusDestination() {
		return busDestination;
	}

	public void setBusDestination(String busDestination) {
		this.busDestination = busDestination;
	}

	public String getBusDate() {
		return busDate;
	}

	public void setBusDate(String busDate) {
		this.busDate = busDate;
	}

}