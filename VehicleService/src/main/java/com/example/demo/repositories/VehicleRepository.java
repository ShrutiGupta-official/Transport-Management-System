package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.VehicleEntity;

public interface VehicleRepository extends CrudRepository<VehicleEntity,String>{
	
	
	
	@Query(value="SELECT * FROM VEHICLE_TABLE v WHERE v.VEHICLE_TYPE ='Sedan'",nativeQuery=true)
	public List<VehicleEntity> findVehiclesByVehicleTypeSedan(String vehicleType);
	
	@Query(value="SELECT * FROM VEHICLE_TABLE v WHERE v.VEHICLE_TYPE ='SUV'",nativeQuery=true)
	public List<VehicleEntity> findVehiclesByVehicleTypeSUV(String vehicleType);
	
	@Query(value="SELECT * FROM VEHICLE_TABLE v WHERE v.VEHICLE_TYPE ='Van'",nativeQuery=true)
	public List<VehicleEntity> findVehiclesByVehicleTypeVan(String vehicleType);
	
			
//	public VehicleEntity findByVehicleType(String vehicleType);
	public VehicleEntity findByRegistrationNo(String registrationNo);
	public List<VehicleEntity> deleteByRegistrationNo(String registrationNo);
}
