package com.vehicle;

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

import com.vehicle.controller.BookingController;
import com.vehicle.entity.JwtResponse;
import com.vehicle.entity.Booking;
import com.vehicle.BookingMain;
import com.vehicle.DAO.BookRepository;
import com.vehicle.feign.BookingFeign;



@SpringBootTest
class BookingMainTest {
	

	//private static final int  = 0;

	@Autowired
	BookingController bc;
	
	@MockBean
	BookRepository brepo;
	

/* @Test
	public void main() {
		BookingMain.main(new String[] {});
	}*/
	
	//bookingList
	
	@Test
	public void testGetAllBookings()throws Exception {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		List<Booking> bll=new ArrayList<>();
		bll.add(new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2));
		bll.add(new Booking(2, "Tata", "Pratyush", "Sambalpur", "balangir", 78, "drop", 230, 50, 80, "Expensive",date,date2));
		
		Mockito.when(brepo.findAll()).thenReturn(bll);
		List<Booking> bl = (List<Booking>) brepo.findAll();
		assertEquals(bll, bl);
	}
	//Authorization
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
	
	//updateBooking
	@Test
	public void testGetAllBookings1() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setDistance(80);
		
		assertEquals(80, bb.getDistance());
	}
	
	@Test
	public void testGetAllBookings2() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setVehicle("Ford");
		
		assertEquals("Ford", bb.getVehicle());
	}
	
	@Test
	public void testGetAllBookings3() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setDriver("Shyam");
		
		assertEquals("Shyam", bb.getDriver());
	}
	
	@Test
	public void testGetAllBookings4() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setFromLocation("Delhi");
		
		assertEquals("Delhi", bb.getFromLocation());
	}
	
	@Test
	public void testGetAllBookings5() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setToLocation("Burla");
		
		assertEquals("Burla", bb.getToLocation());
	}
	
	@Test
	public void testGetAllBookings6() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setType("Drop");
		
		assertEquals("Drop", bb.getType());
	}
	
	@Test
	public void testGetAllBookings7() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setTripfare(250);
		
		assertEquals(250, bb.getTripfare());
	}
	
	@Test
	public void testGetAllBookings8() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setFuel(100);
		
		assertEquals(100, bb.getFuel());
	}
	

	@Test
	public void testGetAllBookings9() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setDriverShare(170);
		
		assertEquals(170, bb. getDriverShare());
	}
	
	@Test
	public void testGetAllBookings10() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setRemarks("Moderate");
		assertEquals("Moderate", bb.getRemarks());
	}
	
	@Test
	public void testGetAllBookings11() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setId(2);
		assertEquals(2, bb.getId());
	}
	
	@Test
	public void testGetAllBookings12() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setStartDate(date2);
		assertEquals(date2, bb.getStartDate());
	}
	
	@Test
	public void testGetAllBookings13() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setEndDate(date);
		assertEquals(date, bb.getEndDate());
	}
	
	@Test
	public void testGetAllBookings14() throws Exception{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		Booking bb =new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2);
		bb.setName("Tata");
		assertEquals("Tata", bb.getName());
	}
	
	@Test
	public void testgetByDate() throws ParseException{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		List<Booking> bll=new ArrayList<Booking>();
		bll.add(new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2));
		bll.add(new Booking(2, "Tata", "Pratyush", "Sambalpur", "balangir", 78, "drop", 230, 50, 80, "Expensive",date,date2));
		
		Mockito.when(brepo.findAllByendDateBefore(date, date2)).thenReturn((List<Booking>) bll);
		List<Booking> bl = brepo.findAllByendDateBefore(date, date2);
		assertEquals(bll, bl);
	}
	
	@Test
	public void testgetByDate1() throws ParseException{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = (Date) simpleDateFormat.parse("2022-07-29");
		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
		List<Booking> bll=new ArrayList<Booking>();
		bll.add(new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2));
		bll.add(new Booking(2, "Tata", "Pratyush", "Sambalpur", "balangir", 78, "drop", 230, 50, 80, "Expensive",date,date2));
		
		Mockito.when(brepo.findAllByendDateBefore(date, date2)).thenReturn((List<Booking>) bll);
		List<Booking> bl = brepo.findAllByendDateBefore(date, date2);
		assertEquals(bll, bl);
	}
//	@Test
//	public void testgetById() throws ParseException{
//		String pattern = "yyyy-MM-dd";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//		Date date = (Date) simpleDateFormat.parse("2022-07-29");
//		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
//		List<Booking> bll=new ArrayList<Booking>();
//		bll.add(new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2));
//		bll.add(new Booking(2, "Tata", "Pratyush", "Sambalpur", "balangir", 78, "drop", 230, 50, 80, "Expensive",date,date2));
//		
//		Mockito.when(brepo.findById(1)).thenReturn((List<Booking>) bll);
//		List<Booking> bl = brepo.findById(1);
//		assertEquals(bll, bl);
//	}
	
//	@Test
//	public void testgetById1() throws ParseException{
//		String pattern = "yyyy-MM-dd";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//		Date date = (Date) simpleDateFormat.parse("2022-07-29");
//		Date date2 = (Date) simpleDateFormat.parse("2022-07-30");
//		List<Booking> bll=new ArrayList<Booking>();
//		bll.add(new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50,70,"Expensive",date,date2));
//		bll.add(new Booking(2, "Tata", "Pratyush", "Sambalpur", "balangir", 78, "drop", 230, 50, 80, "Expensive",date,date2));
//		
//		Mockito.when(brepo.findById(2)).thenReturn((List<Booking>) bll);
//		List<Booking> bl = brepo.findById(2);
//		assertEquals(bll, bl);
//	}
	
	

}
