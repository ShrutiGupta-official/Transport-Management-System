package com.cts.driver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.PageAttributes.MediaType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.driver.Controller.DriverController;
import com.cts.driver.Entity.DriverEntity;
import com.cts.driver.Entity.JwtResponse;
import com.cts.driver.Repo.DriverRepo;

import com.cts.driver.Feign.DriverFeign;


@SpringBootTest
class DriverApplicationTests {
	
	@Autowired
	DriverController dc;
	
	@MockBean
	DriverRepo drepo;
	
	
	/*@Test
	   public void main() {
		DriverApplication.main (new String[] {});
	   }*/
	

	@Test
	public void testGetAllDrivers() {
		List<DriverEntity> dll=new ArrayList<>();
		dll.add(new DriverEntity("TN01X20210000123","Sabheer Ahmed",25,"Sedan"));
		dll.add(new DriverEntity("AP01Z20020000321","Gurumahendra Rao",34,"Van"));
		
		Mockito.when(drepo.findAll()).thenReturn(dll);
		List<DriverEntity> dl = (List<DriverEntity>) drepo.findAll();
		assertEquals(dll, dl);
	}
	@Test
	public void testJwtrepo() {
		JwtResponse jwtr=new JwtResponse("root","root",true);
		jwtr.setValid(false);
		assertEquals("root",jwtr.getUsername());
		
	}
	
	@Test
	public void testJwtrepo2() {
		JwtResponse jwtr=new JwtResponse("root","root",true);
		jwtr.setUserid("admin");
		assertEquals("admin",jwtr.getUserid());
		
	}
	
	@Test
	public void testJwtrepo1() {
		JwtResponse jwtr=new JwtResponse("root","root",false);
		JwtResponse jj=new JwtResponse();
		
		jj.setUsername("admin");
		assertEquals(false,jwtr.isValid());
		
	}
	@Test
	public void testGetAllDrivers1() {
		
		DriverEntity d =new DriverEntity("TN01X20210000123","Sabheer Ahmed",25,"Sedan");
		d.setLicensenumber("TN01X20210000321");
		
		assertEquals("TN01X20210000321", d.getLicensenumber());
	}
	
	@Test
	public void testGetAllDrivers2() {
		
		DriverEntity d =new DriverEntity("TN01X20210000123","Sabheer Ahmed",25,"Sedan");
		d.setName("Ahmed");
		
		assertEquals("Ahmed", d.getName());
	}
	@Test
	public void testGetAllDrivers3() {
		
		DriverEntity d =new DriverEntity("TN01X20210000123","Sabheer Ahmed",25,"Sedan");
		d.setAge(30);
		
		assertEquals(30, d.getAge());
	}
	@Test
	public void testGetAllDrivers4() {
		
		DriverEntity d =new DriverEntity("TN01X20210000123","Sabheer Ahmed",25,"Sedan");
		d.setVehicletype("SUV");
		
		assertEquals("SUV", d.getVehicletype());
	}
	@Test
	public void testgetVehicleByType(){
		List<DriverEntity> dll=new ArrayList<DriverEntity>();
		dll.add(new DriverEntity("TN01X20210000123","Sabheer Ahmed",25,"Sedan"));
		dll.add(new DriverEntity("AP01Z20020000321","Gurumahendra Rao",34,"Van"));
		

		Mockito.when(drepo.findDriversByVehicleTypeSedan("Sedan")).thenReturn((List<DriverEntity>) dll);
		List<DriverEntity> dl =drepo.findDriversByVehicleTypeSedan("Sedan");
		
		assertEquals(dll,dl);
		
		
}
	@Test
	public void testgetVehicleByType1(){
		List<DriverEntity> dll=new ArrayList<DriverEntity>();
		dll.add(new DriverEntity("TN01X20210000123","Sabheer Ahmed",25,"Sedan"));
		dll.add(new DriverEntity("AP01Z20020000321","Gurumahendra Rao",34,"Van"));
		

		Mockito.when(drepo.findDriversByVehicleTypeSUV("SUV")).thenReturn((List<DriverEntity>) dll);
		List<DriverEntity> dl =drepo.findDriversByVehicleTypeSUV("SUV");
		
		assertEquals(dll,dl);
		
		
}
	@Test
	public void testgetVehicleByType2(){
		List<DriverEntity> dll=new ArrayList<DriverEntity>();
		dll.add(new DriverEntity("TN01X20210000123","Sabheer Ahmed",25,"Sedan"));
		dll.add(new DriverEntity("AP01Z20020000321","Gurumahendra Rao",34,"Van"));
		

		Mockito.when(drepo.findDriversByVehicleTypeVan("Van")).thenReturn((List<DriverEntity>) dll);
		List<DriverEntity> dl =drepo.findDriversByVehicleTypeVan("Van");
		
		assertEquals(dll,dl);
		
		
}
		

//}
//	@Test
//	public void testDeleteDriverByLicenseNumber1(){
//		List<DriverEntity> dll =new ArrayList<DriverEntity>();
//		dll.add(new DriverEntity("TN01X20210000123","Sabheer Ahmed",25,"Sedan"));
//		dll.add(new DriverEntity("AP01Z20020000321","Gurumahendra Rao",34,"Van"));
//		
//
//		Mockito.when(drepo.deleteDriversByLicenseNumber("AP01Z20020000321")).thenReturn((List<DriverEntity>) dll);
//		List<DriverEntity> dl =drepo.deleteDriversByLicenseNumber("AP01Z20020000321");
//		
//		assertEquals(dll,dl);
		


}
