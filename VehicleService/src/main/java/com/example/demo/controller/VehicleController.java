package com.example.demo.controller;

import java.util.List;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VehicleServiceApplication;
import com.example.demo.entities.JwtResponse;
import com.example.demo.entities.VehicleEntity;
import com.example.demo.exception.TokenValidationFailedException;
import com.example.demo.feign.AuthClient;
import com.example.demo.repositories.VehicleRepository;
import com.example.demo.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin("*")
public class VehicleController {
	private final static Logger log=LoggerFactory.getLogger(VehicleServiceApplication.class);
	@Autowired
	private VehicleService vs;

	@Autowired
	private AuthClient authClient;
	@Autowired
	private VehicleRepository repo;

	@GetMapping("/Vehicles")
	public ResponseEntity<List<VehicleEntity>> getVehicles(
			@RequestHeader(name = "Authorization", required = true) String token) {
		log.info("START");
		JwtResponse jwtResponse = authClient.verifyToken(token);
		List<VehicleEntity> list = vs.getAllVehicles();

		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		try {
			if (jwtResponse.isValid()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(list);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		log.info("END");
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

//	@GetMapping("/GetAllVehiclesFrontend")
//	public ResponseEntity<List<VehicleEntity>> getVeh(){
//		List<VehicleEntity> list=vs.getAllVehicles();
//		if(list.size()<=0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.status(HttpStatus.CREATED).body(list);
//	}
	
	
	
	
	
	@GetMapping("/VehiclesByType/{vehicleType}")
	@ResponseBody
	public ResponseEntity<List<VehicleEntity>> getVehicleByType(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("vehicleType") String vehicleType) {
		log.info("START");
		JwtResponse jwtResponse = authClient.verifyToken(token);
		VehicleEntity v =new VehicleEntity();
		List<VehicleEntity> list=null;
		
		try {
			if (jwtResponse.isValid()) {
				if (vehicleType.equals("Sedan")) {
					list= vs.getVehiclesByVehicleTypeSedan(vehicleType);
				} else if(vehicleType.equals("SUV")) {
					list= vs.getVehiclesByVehicleTypeSUV(vehicleType);
				} else if(vehicleType.equals("Van")) {
					list= vs.getVehiclesByVehicleTypeVan(vehicleType);
				}
			if (list == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
				
//				v = vs.getVehicleByType(vehicleType);
				

//				return ResponseEntity.of(Optional.of(v));

			}
		} catch (TokenValidationFailedException t) {
			// TODO: handle exception
			throw new TokenValidationFailedException("token expired");
		}
        return ResponseEntity.ok().body(list);

	}

//	@GetMapping("/Vehicles/{registrationNo}")
//	public ResponseEntity<List<VehicleEntity>> getVehicleRegistration(
//			@RequestHeader(name = "Authorization", required = true) String token, @PathVariable String registrationNo) {
//		log.info("START");
//		JwtResponse jwtResponse = authClient.verifyToken(token);
//		List<VehicleEntity> v = null;
//		try {
//			if (jwtResponse.isValid()) {
//				v = vs.getVehicleByRegistrationNo(registrationNo);
//				if (v == null) {
//					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//				}
//
//				return ResponseEntity.of(Optional.of(v));
//
//			}
//		} catch (TokenValidationFailedException t) {
//			// TODO: handle exception
//			throw new TokenValidationFailedException("token expired");
//		}
//		log.info("END");
//		return ResponseEntity.of(Optional.of(v));
//		// return vs.getVehicleByRegistrationNo(registrationNo);
//
//	}
	
	@GetMapping("/Vehicles/{registrationNo}")
	public ResponseEntity<VehicleEntity> getVehicleRegistration(
			@RequestHeader(name = "Authorization", required = true) String token, @PathVariable String registrationNo) {
		log.info("START");
		JwtResponse jwtResponse = authClient.verifyToken(token);
		VehicleEntity v = null;
		try {
			if (jwtResponse.isValid()) {
				v = vs.getVehicleByRegistrationNo(registrationNo);
				if (v == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}

				return ResponseEntity.of(Optional.of(v));

			}
		} catch (TokenValidationFailedException t) {
			// TODO: handle exception
			throw new TokenValidationFailedException("token expired");
		}
		log.info("END");
		return ResponseEntity.of(Optional.of(v));
		// return vs.getVehicleByRegistrationNo(registrationNo);

	}

	@PostMapping("/AddVehicle")
	public ResponseEntity<VehicleEntity> addVehicle(
			@RequestHeader(name = "Authorization", required = true) String token, @RequestBody VehicleEntity v) {
		log.info("START");
		VehicleEntity vehicleEntity = null;
		JwtResponse jwtResponse = authClient.verifyToken(token);
		try {
			if (jwtResponse.isValid()) {
			
				repo.save(v);
				
                return ResponseEntity.status(HttpStatus.CREATED).build();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		

	}

	@DeleteMapping("/deleteVehicle/{registrationNo}")
	public ResponseEntity<Void> deleteVehicle(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("registrationNo") String registrationNo) {
		log.info("START");
		JwtResponse jwtResponse = authClient.verifyToken(token);
		try {
			if (jwtResponse.isValid()) {
				this.vs.deleteVehicle(registrationNo);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		log.info("END");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		// this.vs.deleteVehicle(registrationNo);
	}

	@PutMapping("/updateVehicle/{registrationNo}")
	public ResponseEntity<VehicleEntity> updateVehicle(
			@RequestHeader(name = "Authorization", required = true) String token, @RequestBody VehicleEntity v,
			@PathVariable("registrationNo") String registrationNo) {
		// this.vs.updateVehicle(vehicleEntity,registrationNo);
		log.info("START");
		JwtResponse jwtResponse = authClient.verifyToken(token);
		try {
			if (jwtResponse.isValid()) {
				this.vs.updateVehicle(v, registrationNo);
				return ResponseEntity.ok().body(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		log.info("END");
		return ResponseEntity.ok().body(v);
	}

}
