package com.vehicle.controller;

import java.sql.Date;

import java.util.List;
import java.util.Optional;

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

import com.vehicle.entity.Booking;
import com.vehicle.entity.DriverEntity;
import com.vehicle.entity.JwtResponse;
import com.vehicle.entity.VehicleEntity;
import com.vehicle.exception.TokenValidationException;
import com.vehicle.feign.BookingFeign;
import com.vehicle.feign.DriverFeign;
import com.vehicle.feign.VehicleFeign;
import com.vehicle.service.BookingService;

@RestController
@CrossOrigin("*")
public class BookingController {

	@Autowired
	private BookingService bs;
	


	// auth client
	@Autowired
	private BookingFeign authBooking;
	
	@Autowired
	DriverFeign driver;
	
	@GetMapping("/testDriver")
	public List<DriverEntity> getDriverInfo(@RequestHeader(name="Authorization") String token)
	{
		return driver.getAllDrivers(token);	
	}
	@GetMapping("/testDriversByVehicleType/{vehicleType}")
    public List<DriverEntity> getDriver(@RequestHeader(name= "Authorization", required = true) String token,@PathVariable("vehicleType")String vehicleType)
	{
		return driver.getAllDriversByType(token,vehicleType);
    }
	

	
	@PostMapping("/testAddDriver")
	public void  AddDriver(@RequestHeader(name="Authorization") String token, @RequestBody DriverEntity driverEntity)
	{
		driver.addDriver(token,driverEntity);	
	}
	@DeleteMapping("/testdeleteDriver/{licenseNumber}")
	public void  deleteDriver(@RequestHeader(name = "Authorization", required = true) String token, @PathVariable("licenseNumber")String licenseNumber)
	{
		driver.deleteDriver(token, licenseNumber);	
	}
	
	
	@Autowired
	VehicleFeign vehicle;
	
	@GetMapping("/testVehicle")
	public ResponseEntity<List<VehicleEntity>> getVehicles(@RequestHeader(name = "Authorization", required = true) String token)
	{
		return vehicle.getVehicles(token);	
	}
	@GetMapping("/testVehiclesByType/{vehicleType}")
	public ResponseEntity<VehicleEntity> getVehicleByType(@RequestHeader(name = "Authorization", required = true) String token, @PathVariable("vehicleType") String vehicleType)
	{
		return vehicle.getVehicleByType(token, vehicleType);	
	}
	@GetMapping("/testVehicles/{registrationNo}")
	public ResponseEntity<VehicleEntity> getVehicleRegistration(@RequestHeader(name = "Authorization", required = true) String token, @PathVariable String registrationNo)
	{
		return vehicle.getVehicleRegistration(token, registrationNo);
	}
	@PostMapping("/testAddVehicle")
	public ResponseEntity<VehicleEntity> addVehicle(@RequestHeader(name = "Authorization", required = true) String token, @RequestBody VehicleEntity v)
	{
		return vehicle.addVehicle(token, v);
	}
	@DeleteMapping("/testdeleteVehicle/{registrationNo}")
	public ResponseEntity<Void> deleteVehicle(@RequestHeader(name = "Authorization", required = true) String token,@PathVariable("registrationNo") String registrationNo)
	{
		return vehicle.deleteVehicle(token, registrationNo);
	}
	

	@GetMapping("/GetAllBookings")
	@ResponseBody
	public ResponseEntity<List<Booking>> getBooks(
			@RequestHeader(name = "Authorization", required = true) String token) {
		JwtResponse jwtResponse = authBooking.verifyToken(token);
		List<Booking> list = this.bs.getAllDetails();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		try {
			if (jwtResponse.isValid()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	@CrossOrigin("*")
	@GetMapping("/GetBookingById/{id}")
	@ResponseBody
	public ResponseEntity<Booking> getById(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable int id) {

		JwtResponse jwtResponse = authBooking.verifyToken(token);
		Booking b = this.bs.getById(id);
		try {
			if (jwtResponse.isValid()) {

				if (b == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return ResponseEntity.of(Optional.of(b));
			}
		} catch (TokenValidationException t) {
			throw new TokenValidationException("Token Expired");
		}
		return ResponseEntity.of(Optional.of(b));
	}

	@GetMapping("/GetBookingsByDateTime/{start}/{end}")
	public ResponseEntity<List<Booking>> getByDate(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable Date start, @PathVariable Date end) {
		System.out.println("Start Date="+start+"End Date="+end);
		List<Booking> b = this.bs.getByDate(start, end);
		JwtResponse jwtResponse = authBooking.verifyToken(token);
		try {
			if (jwtResponse.isValid()) {
				if (b == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return ResponseEntity.of(Optional.of(b));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(b));
	}

	@PostMapping("/AddBooking")
	public ResponseEntity<Booking> AddBooking(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody Booking b) {
		Booking booking = null;
		JwtResponse jwtResponse = authBooking.verifyToken(token);
		try {
			if (jwtResponse.isValid()) {
				booking = this.bs.addBooking(b);
				return ResponseEntity.of(Optional.of(b));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.of(Optional.of(b));
	}

	@PutMapping("UpdateBooking/{BookId}")
	public ResponseEntity<Booking> updateBooking(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody Booking b, @PathVariable int BookId) {
		JwtResponse jwtResponse = authBooking.verifyToken(token);
		try {
			if (jwtResponse.isValid()) {
				this.bs.UpdateBooking(b, BookId);
				return ResponseEntity.ok().body(b);
			}
		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok().body(b);
	}

}
//http://localhost:8080/GetBookingsByDateTime/0001-01-01/0002-02-02
//	http://localhost:8080/GetAllBookings
