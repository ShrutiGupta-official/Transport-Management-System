package com.vehicle;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@SpringBootApplication
@EnableWebMvc
@EnableFeignClients
public class BookingMain {
	public static void main(String[] args) {
		SpringApplication.run(BookingMain.class, args);
	}
}
