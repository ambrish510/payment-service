package com.upgrad.paymentservice.feign;

import com.upgrad.paymentservice.model.JwtTokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "security-service", url = "http://localhost:8086/security-service/security")
public interface SecurityServiceClient {

    @PostMapping("/generate-token")
    public String generateToken(@RequestBody JwtTokenRequest tokenRequest);
}
