package com.cts.driver.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.driver.Entity.JwtResponse;

@FeignClient(name="authorization-service",url="http://localhost:7072")

public interface DriverFeign {
    @GetMapping("/api/auth/validate")
    public JwtResponse verifyToken(@RequestHeader(name="authorization",required=true) String token);
}
