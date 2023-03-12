package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.PageAttributes.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
import org.mockito.exceptions.misusing.UnfinishedStubbingException;
import com.example.demo.controller.VehicleController;
import com.example.demo.entities.JwtResponse;
import com.example.demo.entities.VehicleEntity;
import com.example.demo.repositories.VehicleRepository;

import com.example.demo.feign.AuthClient;

@SpringBootTest
class VehicleServiceApplicationTests {
	
	@Autowired
	VehicleController vc;
	
	@MockBean
	VehicleRepository vrepo;
	

	@Test
	public void testGetAllVehicles00() {
		List<VehicleEntity> vll=new ArrayList<>();
		vll.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
		vll.add(new VehicleEntity("AP02CD0202", "Chevrolet Tavera","SUV", 9, "No"));
		
		Mockito.when(vrepo.findAll()).thenReturn(vll);
		List<VehicleEntity> vl = (List<VehicleEntity>) vrepo.findAll();
		assertEquals(vll, vl);
	}
	@Test
	public void testGetAllVehicles01() {
		List<VehicleEntity> vll=new ArrayList<>();
		vll.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
		vll.add(new VehicleEntity("AP026DAF52", "Tavera","Van", 9, "No"));
		
		Mockito.when(vrepo.findAll()).thenReturn(vll);
		List<VehicleEntity> vl = (List<VehicleEntity>) vrepo.findAll();
		assertEquals(vll, vl);
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
	public void testGetAllVehicles1() {
		
		VehicleEntity vv=new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes");
		vv.setRegistrationNo("TN01AB0102");
		
		assertEquals("TN01AB0102", vv.getRegistrationNo());
	}
	
	@Test
	public void testGetAllVehicles2() {
		
		VehicleEntity vv=new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes");
		vv.setModelType("Mahindra Tourister");
		
		assertEquals("Mahindra Tourister", vv.getModelType());
	}
	
	@Test
	public void testGetAllVehicles3() {
		
		VehicleEntity vv=new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes");
		vv.setVehicleType("Van");
		
		assertEquals("Van", vv.getVehicleType());
	}
	
	@Test
	public void testGetAllVehicles4() {
		
		VehicleEntity vv=new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes");
		vv.setNumberOfSeat(5);
		
		assertEquals(5, vv.getNumberOfSeat());
	}
	@Test
	public void testGetAllVehicles5() {
		
		VehicleEntity vv=new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes");
		vv.setAcAvailable("NO");
		
		assertEquals("NO", vv.getAcAvailable());
	}
	
	
//	@Test
//	public void testVehicleByRegistrationNo(){
//		List<VehicleEntity> ve =new ArrayList<VehicleEntity>();
//		ve.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
//		ve.add(new VehicleEntity("AP02CD0202", "Chevrolet Tavera","SUV", 9, "No"));
//
//		Mockito.when(vrepo.findByRegistrationNo("TN01AB0101")).thenReturn((List<VehicleEntity>) ve);
//		List<VehicleEntity> vel = vrepo.findByRegistrationNo("TN01AB0101");
//		
//		assertEquals(ve,vel);
//		
//		
//}
	
//	@Test
//	public void testVehicleByRegistrationNo1(){
//		List<VehicleEntity> ve =new ArrayList<VehicleEntity>();
//		ve.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
//		ve.add(new VehicleEntity("AP02CD0202", "Chevrolet Tavera","SUV", 9, "No"));
//
//		Mockito.when(vrepo.findByRegistrationNo("AP02CD0202")).thenReturn((List<VehicleEntity>) ve);
//		List<VehicleEntity> vel = vrepo.findByRegistrationNo("AP02CD0202");
//		
//		assertEquals(ve,vel);
//		
//		
//}
	@Test
	public void testgetVehicleByType(){
		List<VehicleEntity> ve =new ArrayList<VehicleEntity>();
		ve.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
		ve.add(new VehicleEntity("AP02CD0202", "Chevrolet Tavera","SUV", 9, "No"));

		Mockito.when(vrepo.findVehiclesByVehicleTypeSedan("Sedan")).thenReturn((List<VehicleEntity>) ve);
		List<VehicleEntity> vel =vrepo.findVehiclesByVehicleTypeSedan("Sedan");
		
		assertEquals(ve,vel);
		
		
}
	
	@Test
	public void testgetVehicleByType1(){
		List<VehicleEntity> ve =new ArrayList<VehicleEntity>();
		ve.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
		ve.add(new VehicleEntity("AP02CD0202", "Chevrolet Tavera","SUV", 9, "No"));

		Mockito.when(vrepo.findVehiclesByVehicleTypeSUV("SUV")).thenReturn((List<VehicleEntity>) ve);
		List<VehicleEntity> vel =vrepo.findVehiclesByVehicleTypeSUV("SUV");
		
		assertEquals(ve,vel);
		
		
}
	@Test
	public void testgetVehicleByType2(){
		List<VehicleEntity> ve =new ArrayList<VehicleEntity>();
		ve.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
		ve.add(new VehicleEntity("AP02CD0202", "Chevrolet Tavera","SUV", 9, "No"));

		Mockito.when(vrepo.findVehiclesByVehicleTypeVan("Van")).thenReturn((List<VehicleEntity>) ve);
		List<VehicleEntity> vel =vrepo.findVehiclesByVehicleTypeVan("Van");
		
		assertEquals(ve,vel);
		
		
}
	@Test
	public void testDeleteVehicleByRegistrationNo(){
		List<VehicleEntity> ve =new ArrayList<VehicleEntity>();
		ve.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
		ve.add(new VehicleEntity("AP02CD0202", "Chevrolet Tavera","SUV", 9, "No"));

		Mockito.when(vrepo.deleteByRegistrationNo("TN01AB0101")).thenReturn((List<VehicleEntity>) ve);
		List<VehicleEntity> vel = vrepo.deleteByRegistrationNo("TN01AB0101");
		
		assertEquals(ve,vel);
		
		
}
	@Test
	public void testDeleteVehicleByRegistrationNo1(){
		List<VehicleEntity> ve =new ArrayList<VehicleEntity>();
		ve.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
		ve.add(new VehicleEntity("AP02CD0202", "Chevrolet Tavera","SUV", 9, "No"));

		Mockito.when(vrepo.deleteByRegistrationNo("AP02CD0202")).thenReturn((List<VehicleEntity>) ve);
		List<VehicleEntity> vel = vrepo.deleteByRegistrationNo("AP02CD0202");
		
		assertEquals(ve,vel);
		
		
}
	
	/*@Test
	public void deleteVehicle(String srNo ) {
		vrepo.deleteById(srNo);
		List<VehicleEntity> vll=new ArrayList<>();
		vll.add(new VehicleEntity("TN01AB0101", "Hyundai Xcent", "Sedan",4, "Yes"));
	    vll = vll.stream().filter(veh -> veh.getRegistrationNo() != srNo).collect(Collectors.toList());
	}*/

}
	

