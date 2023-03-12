package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Vehicle_Table")

public class VehicleEntity {
	
	@Id
//	@GeneratedValue
	//(generator = "system-uuid")
//	@GenericGenerator(name="system-uuid",strategy = "uuid")
	private String registrationNo;
	@Column
	private String modelType;
	@Column
	private String vehicleType;
	@Column
	private int numberOfSeat;
	@Column
	private String acAvailable;
	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	public String getAcAvailable() {
		return acAvailable;
	}

	public void setAcAvailable(String acAvailable) {
		this.acAvailable = acAvailable;
	}

	

	public VehicleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleEntity(String registrationNo, String modelType, String vehicleType, int numberOfSeat,
			String acAvailable) {
		super();
		this.registrationNo = registrationNo;
		this.modelType = modelType;
		this.vehicleType = vehicleType;
		this.numberOfSeat = numberOfSeat;
		this.acAvailable = acAvailable;
	}

}
