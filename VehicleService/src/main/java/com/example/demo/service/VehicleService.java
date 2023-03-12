package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.VehicleEntity;
import com.example.demo.repositories.VehicleRepository;

@Component
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	// public static List<VehicleEntity> list = new ArrayList<VehicleEntity>();

	/*
	 * static { list.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",
	 * 4, "Yes")); list.add(new VehicleEntity("AP02CD0202", "Chevrolet Tavera",
	 * "SUV", 9, "No")); list.add(new VehicleEntity("KL03EF0303", "Chevrolet Enjoy",
	 * "SUV", 7, "Yes")); list.add(new VehicleEntity("KA04GH0404",
	 * "Mahindra Tourister", "Van", 15, "No")); list.add(new
	 * VehicleEntity("TN01AB0202", "Chevrolet Tavera", "SUV", 9, "Yes")); }
	 */

	public List<VehicleEntity> getAllVehicles() {
		List<VehicleEntity> list = (List<VehicleEntity>) this.vehicleRepository.findAll();
		return list;

	}
	
    public List<VehicleEntity> getVehiclesByVehicleTypeSedan(String vehicleType) {

        List<VehicleEntity> sedan = vehicleRepository.findVehiclesByVehicleTypeSedan(vehicleType);
        return sedan;
    }
    
    public List<VehicleEntity> getVehiclesByVehicleTypeSUV(String vehicleType) {

        List<VehicleEntity> suv = vehicleRepository.findVehiclesByVehicleTypeSUV(vehicleType);
        return suv;
    }
    public List<VehicleEntity> getVehiclesByVehicleTypeVan(String vehicleType) {

        List<VehicleEntity> van = vehicleRepository.findVehiclesByVehicleTypeVan(vehicleType);
        return van;
    }



//	public List<VehicleEntity> getVehicleByRegistrationNo(String registrationNo) {
//		List<VehicleEntity> v = null;
//		try {
//			v = this.vehicleRepository.findByRegistrationNo(registrationNo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// v = list.stream().filter(e -> e.getRegistrationNo() ==
//		// registrationNo).findFirst().get();
//		return v;
//
//	}
    
    public VehicleEntity getVehicleByRegistrationNo(String registrationNo) {
		VehicleEntity v = null;
		try {
			v = this.vehicleRepository.findByRegistrationNo(registrationNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// v = list.stream().filter(e -> e.getRegistrationNo() ==
		// registrationNo).findFirst().get();
		return v;

	}

	public VehicleEntity addVehicle(VehicleEntity v) {
		// list.add(v);
		VehicleEntity result = this.vehicleRepository.save(v);
		return result;
	}

	public void deleteVehicle(String srNo) {
		vehicleRepository.deleteById(srNo);
		// list = list.stream().filter(veh -> veh.getRegistrationNo() !=
		// srNo).collect(Collectors.toList());
	}

	public void updateVehicle(VehicleEntity vehicleEntity, String registrationNo) {
		vehicleEntity.setRegistrationNo(registrationNo);
		vehicleRepository.save(vehicleEntity);
	}

}
