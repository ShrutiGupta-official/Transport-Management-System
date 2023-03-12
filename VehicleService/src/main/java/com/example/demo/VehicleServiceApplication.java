package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableWebMvc
@EnableFeignClients
public class VehicleServiceApplication {
	private final static Logger log=LoggerFactory.getLogger(VehicleServiceApplication.class);
	public static void main(String[] args) {
		log.info("START");
		SpringApplication.run(VehicleServiceApplication.class, args);
		log.info("END");
	}

}
