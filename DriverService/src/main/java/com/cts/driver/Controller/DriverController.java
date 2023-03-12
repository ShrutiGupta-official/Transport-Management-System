package com.cts.driver.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.driver.Entity.DriverEntity;
import com.cts.driver.Entity.JwtResponse;
import com.cts.driver.Exception.TokenValidationFailedException;
import com.cts.driver.Feign.DriverFeign;
import com.cts.driver.Repo.DriverRepo;
import com.cts.driver.Service.Driverms1ServiceImplementation;

@RestController
@CrossOrigin("*")
public class DriverController {

    @Autowired
    private Driverms1ServiceImplementation dms;
    @Autowired
    private DriverRepo repo;
    @Autowired
    private DriverFeign driverFeign;

    @GetMapping("/Drivers")
    public ResponseEntity<List<DriverEntity>> getDrivers(
            @RequestHeader(name = "Authorization" , required = true) String token){
            JwtResponse jwtResponse = driverFeign.verifyToken(token);
            List<DriverEntity> list = dms.getAllDrivers();
            
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        }
        try{
            if(jwtResponse.isValid()) {
        	
                return ResponseEntity.status(HttpStatus.CREATED).body(list);
            }
        } catch (Exception e){
            // TODO: handle exception
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
//   @GetMapping("/testsedan/{sedan}")
//    public ResponseEntity<List<DriverEntity>> testSedan(@PathVariable("sedan") String sedan){
 //   	return ResponseEntity.ok().body( repo.findByvehicletype("Sedan"));
    	
  //  }

    @GetMapping("/DriversByVehicleType/{vehicleType}")
    public ResponseEntity<List<DriverEntity>> getDriver(
            @RequestHeader(name= "Authorization", required = true) String token,
            @PathVariable("vehicleType")String vehicleType) {
        JwtResponse jwtResponse = driverFeign.verifyToken(token);
        List<DriverEntity> list=null;
        try{
            if(jwtResponse.isValid()) {

            
            if (vehicleType.equals("Sedan")) {
            	//list.add("Sedan");
//            ls2= repo.findByVehicleType("Sedan");
            list = dms.getDriversByVehicleTypeSedan();

        } else if (vehicleType.equals("SUV")) {
        	//list.add("Sedan");
        	//list.add("SUV");
            list = dms.getDriversByVehicleTypeSUV();

        } else if (vehicleType.equals("Van")) {
        	return ResponseEntity.ok().body((List<DriverEntity>)repo.findAll());
        }

        if (list == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //return ResponseEntity.ok().body( repo.findByvehicletype("Sedan"));
            }

    } catch (TokenValidationFailedException t) {
			// TODO: handle exception
			throw new TokenValidationFailedException("token expired");
		}
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/AddDriver")
    public ResponseEntity<DriverEntity> addDriver(
            @RequestHeader(name="Authorization" ,required = true) String token, @RequestBody DriverEntity driverEntity) {
        JwtResponse jwtResponse = driverFeign.verifyToken(token);
        try {
                 if(jwtResponse.isValid()){
        	
                	 repo.save(driverEntity);
                	 //d = (DriverEntity) dms.addDriver(d);
                                 //System.out.println(driverms1Entity);
                                 return ResponseEntity.status(HttpStatus.CREATED).build();
                      }
        } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
         return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/deleteDriver/{licensenumber}")
    public ResponseEntity<Void> deleteDriver(
            @RequestHeader(name = "Authorization", required = true) String token,
            @PathVariable("licensenumber")String licensenumber) {
        JwtResponse jwtResponse = driverFeign.verifyToken(token);
        try {
            if (jwtResponse.isValid()) {
            
        	dms.deleteDriver(licensenumber);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		// dms.deleteDriver(licensenumber);
	}

    

}
