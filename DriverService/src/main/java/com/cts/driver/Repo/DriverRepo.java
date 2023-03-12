package com.cts.driver.Repo;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cts.driver.Entity.DriverEntity;

public interface DriverRepo extends CrudRepository<DriverEntity, String> {

    @Query(value="SELECT * FROM DRIVERMS1ENTITY d  WHERE d.VEHICLETYPE = 'Sedan'",nativeQuery=true)
    public List<DriverEntity> findDriversByVehicleTypeSedan(String vehicleType);
    
     @Query(value="SELECT * FROM DRIVERMS1ENTITY d  WHERE  d.VEHICLETYPE='SUV'",nativeQuery=true)
    public List<DriverEntity> findDriversByVehicleTypeSUV(String vehicleType);
    
     @Query(value="SELECT * FROM DRIVERMS1ENTITY d  WHERE  d.VEHICLETYPE='Van'",nativeQuery=true)
    public List<DriverEntity> findDriversByVehicleTypeVan(String vehicleType);

    
	public List<DriverEntity> findByvehicletype(String string);
	//public List<DriverEntity> deleteDriversByLicenseNumber(String licensenumber);

//	@Query(value="select * from DRIVERMS1ENTITY d where d.VEHICLETYPE = ?1", nativeQuery=true)
//	public List<DriverEntity> findAllvehicleBytype(String string);

    //@Override
    //public com.cts.driver.Entity.DriverEntity save(com.cts.driver.Entity.DriverEntity d);
}
