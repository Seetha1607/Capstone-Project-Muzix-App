package com.example.MovieService.Proxy;

import com.example.MovieService.Domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authentication-service",url = "authentication-service:8085")
public interface UserProxy {
    @PostMapping("/api/v1/register")
    public ResponseEntity<?> registerUser(@RequestBody User user);
}
