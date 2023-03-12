package com.vehicle.DAO;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vehicle.entity.Booking;



public interface BookRepository extends JpaRepository<Booking, Integer>{
	public Booking findById(int id);


	@Query(value="select * from bookingDB b where b.START_DATE >=?2 and b.END_DATE<=?1 ", nativeQuery=true)
	public List<Booking> findAllByendDateBefore(Date end,Date start);
	
	//SELECT * FROM BOOKINGDB where END_DATE<='2022-07-29' and START_DATE >='2022-07-20'
}
