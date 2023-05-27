package com.pragma.hexagonal.infraestructure.port.in.web;

import com.pragma.hexagonal.application.dto.request.RestaurantRequestDto;
import com.pragma.hexagonal.application.handler.IRestaurantHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurant")
@AllArgsConstructor
public class RestaurantController {

    private final IRestaurantHandler restaurantHandler;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> save(@RequestBody RestaurantRequestDto restaurantRequestDto){
        restaurantHandler.save(restaurantRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
