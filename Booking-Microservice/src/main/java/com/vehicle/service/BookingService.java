package com.vehicle.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vehicle.DAO.BookRepository;
import com.vehicle.entity.Booking;

@Component
public class BookingService {
//	private static List<Booking> list = new ArrayList<Booking>();
//	
//	static {
//		list.add(new Booking(1, "BMW", "Ram", "sonepur", "burla", 50, "drop", 200, 50, 70, "Expensive"));
//		list.add(new Booking(2, "Tata", "Pratyush", "Sambalpur", "balangir", 78, "drop", 230, 50, 80, "Expensive"));
//	}
	// sql config
	@Autowired
	private BookRepository br;
	
	public List<Booking> getAllDetails() {
		List<Booking> list = (List<Booking>) this.br.findAll();
		return list;
	}

	public Booking getById(int id) {
		Booking b = null;
		try {
//		b = list.stream().filter(e -> e.getId() == id).findFirst().get();
			b = this.br.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public Booking addBooking(Booking b) {
		Booking res = this.br.save(b); 
		return res; //returns the newly added object
	}

	public void UpdateBooking(Booking booking, int id) {
		// use map to operate on each booking object
//		list = list.stream().map(b -> {
//
//			if (b.getId() == id) {
//				b.setName(booking.getName());
//				// only updating the name for the time beging
//			}
//			return b;
//		}).collect(Collectors.toList());
		booking.setId(id);
		br.save(booking); 
	}
	public List<Booking> getByDate(Date start, Date end) {
		System.out.println(start);
		System.out.println(end);
		Booking b = null;
		//List<Booking> list=null;
		List<Booking> list = (List<Booking>) this.br.findAllByendDateBefore(end,start);
		//System.out.println(list);
		
//		try {
//			System.out.println("Entered Try");
//			
//			for (Booking booking : list) {
//				System.out.println("Entered Loop");
//				if(booking.getStartDate().after(start) && booking.getEndDate().before(end)) {
////					sol.add(booking);
//					System.out.println("Added Date");
//				} else {
//					System.out.println("Removed Date");
//					list.remove(booking);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return list; 
	}
}
