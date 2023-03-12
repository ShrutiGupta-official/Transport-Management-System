
package com.cts.driver.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.cts.driver.Entity.DriverEntity;
import com.cts.driver.Repo.DriverRepo;


@Service
@Transactional
public class Driverms1ServiceImplementation implements DriverService{

    @Autowired
    private DriverRepo driverRepo;

    @Override
    public List<DriverEntity> getAllDrivers() {
        List<DriverEntity> list;
        list = (List<DriverEntity>) driverRepo.findAll();
        return list;

    }

    
    public List<DriverEntity> getDriversByVehicleTypeSedan(String vehicleType) {

        List<DriverEntity> sedan = driverRepo.findDriversByVehicleTypeSedan(vehicleType);
        return sedan;
    }
    
    
    public List<DriverEntity> getDriversByVehicleTypeSUV(String vehicleType) {

        List<DriverEntity> suv = driverRepo.findDriversByVehicleTypeSedan(vehicleType);
        return suv;
    }
    
   
    public List<DriverEntity> getDriversByVehicleTypeVan(String vehicleType) {

        List<DriverEntity> van = driverRepo.findDriversByVehicleTypeSedan(vehicleType);
        return van;
    }

    @Override
    public DriverEntity addDriver(DriverEntity d) {
        // list.add(d);
        DriverEntity result = driverRepo.save(d);
        return result;
    }

    @Override
    @Modifying
    public void deleteDriver(String srNo) {
        driverRepo.deleteById(srNo);

    }


	@Override
	public List<DriverEntity> getDriversByVehicleTypeSedan() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<DriverEntity> getDriversByVehicleTypeSUV() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<DriverEntity> getDriversByVehicleTypeVan() {
		// TODO Auto-generated method stub
		return null;
	}
    

    

}