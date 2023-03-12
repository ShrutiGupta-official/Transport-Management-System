package com.vehicle.feign;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.vehicle.entity.DriverEntity;

@FeignClient(url="http://localhost:8088", name="DriverService")
public interface DriverFeign {
	@GetMapping("/Drivers")
	public List<DriverEntity> getAllDrivers(@RequestHeader(name="authorization") String token);
	
	@GetMapping("/DriversByVehicleType/{vehicleType}")
	public List<DriverEntity> getAllDriversByType(@RequestHeader(name="authorization") String token,@PathVariable("vehicleType")String vehicleType);
	
	@PostMapping("/AddDriver")
	public ResponseEntity<DriverEntity> addDriver(@RequestHeader(name="authorization" ,required = true) String token, @RequestBody DriverEntity driverEntity);
	
	@DeleteMapping("/deleteDriver/{licenseNumber}")
    public ResponseEntity<Void> deleteDriver(@RequestHeader(name = "authorization", required = true) String token,@PathVariable("licenseNumber")String licenseNumber);
	
}
