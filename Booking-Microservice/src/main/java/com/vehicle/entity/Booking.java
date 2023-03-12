package com.vehicle.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookingDB")
public class Booking {
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue// auto incrementing
	private int id;
	private String vehicle;
	private String driver;
	private String fromLocation;
	private String toLocation;
	private int distance;
	private String type;
	private int tripfare;
	private int fuel;
	private int dShare;
	private String remarks;
	private java.util.Date startDate;
	private java.util.Date endDate;

	public Booking(int id, String vehicle, String driver, String fromLocation, String toLocation, int distance,
			String type, int tripfare, int fuel, int dShare, String remarks, java.util.Date startDate, java.util.Date endDate) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.distance = distance;
		this.type = type;
		this.tripfare = tripfare;
		this.fuel = fuel;
		this.dShare = dShare;
		this.remarks = remarks;
		this.startDate = (Date) startDate;
		this.endDate = (Date) endDate;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date date2) {
		this.startDate = date2;
	}

	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTripfare() {
		return tripfare;
	}

	public void setTripfare(int tripfare) {
		this.tripfare = tripfare;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public int getDriverShare() {
		return dShare;
	}

	public void setDriverShare(int dShare) {
		this.dShare = dShare;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

//	public Booking(int id, String vehicle, String driver, String fromLocation, String toLocation, int distance,
//			String type, int tripfare, int fuel, int driverShare, String remarks, String startDate, String endDate) {
//		super();
//		this.id = id;
//		this.vehicle = vehicle;
//		Driver = driver;
//		FromLocation = fromLocation;
//		ToLocation = toLocation;
//		Distance = distance;
//		Type = type;
//		Tripfare = tripfare;
//		Fuel = fuel;
//		DriverShare = driverShare;
//		this.remarks = remarks;
//		this.startDate = startDate;
//		this.endDate = endDate;
//	}

//
//	public Booking(int id, String vehicle, String driver, String fromLocation, String toLocation, int distance,
//			String type, int tripfare, int fuel, int driverShare, String remarks) {
//		super();
//		this.id = id;
//		this.vehicle = vehicle;
//		Driver = driver;
//		FromLocation = fromLocation;
//		ToLocation = toLocation;
//		Distance = distance;
//		Type = type;
//		Tripfare = tripfare;
//		Fuel = fuel;
//		DriverShare = driverShare;
//		this.remarks = remarks;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return vehicle;
	}

	public void setName(String name) {
		this.vehicle = name;
	}

}
