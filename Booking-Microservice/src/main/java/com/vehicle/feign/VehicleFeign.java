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
import org.springframework.web.bind.annotation.ResponseBody;

import com.vehicle.entity.VehicleEntity;

@FeignClient(url="http://localhost:8089", name="VehicleService")
public interface VehicleFeign {

	@GetMapping("/Vehicles")
	public ResponseEntity<List<VehicleEntity>> getVehicles(@RequestHeader(name = "authorization", required = true) String token);
	
	@GetMapping("/VehiclesByType/{vehicleType}")
	public ResponseEntity<VehicleEntity> getVehicleByType(@RequestHeader(name = "authorization", required = true) String token, @PathVariable("vehicleType") String vehicleType);
	
	@GetMapping("/Vehicles/{registrationNo}")
	public ResponseEntity<VehicleEntity> getVehicleRegistration(@RequestHeader(name = "authorization", required = true) String token, @PathVariable String registrationNo);
	
	@PostMapping("/AddVehicle")
	public ResponseEntity<VehicleEntity> addVehicle(@RequestHeader(name = "authorization", required = true) String token, @RequestBody VehicleEntity v);
	
	@DeleteMapping("/deleteVehicle/{registrationNo}")
	public ResponseEntity<Void> deleteVehicle(@RequestHeader(name = "authorization", required = true) String token, @PathVariable("registrationNo") String registrationNo);
}
