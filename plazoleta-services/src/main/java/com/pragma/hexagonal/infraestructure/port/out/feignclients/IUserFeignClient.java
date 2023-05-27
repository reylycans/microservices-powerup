package com.pragma.hexagonal.infraestructure.port.out.feignclients;

import com.pragma.hexagonal.infraestructure.port.out.feignclients.dto.UserFeignDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service",url="localhost:8081/api/user")
public interface IUserFeignClient {
    @GetMapping
    UserFeignDto getUserById(@RequestParam(value = "userId") Long userId);
    @GetMapping("/userByEmail")
    UserFeignDto getUserByEmail(@RequestParam(value = "email") String email);
}
