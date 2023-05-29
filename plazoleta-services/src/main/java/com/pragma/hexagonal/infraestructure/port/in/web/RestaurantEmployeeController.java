package com.pragma.hexagonal.infraestructure.port.in.web;

import com.pragma.hexagonal.application.dto.request.RestaurantEmployeeRequestDto;
import com.pragma.hexagonal.application.handler.IRestaurantEmployeeHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurantEmployee")
@AllArgsConstructor
public class RestaurantEmployeeController {

    private final IRestaurantEmployeeHandler restaurantEmployeeHandler;

    @Operation(summary = "add a new restaurant employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "restaurant created",content = @Content),
            @ApiResponse(responseCode = "409",description = "restaurant already exists",content = @Content)
    })
    @PostMapping
    @PreAuthorize("hasAuthority('OWNER')")
    public ResponseEntity<Void> save(@RequestBody RestaurantEmployeeRequestDto restaurantEmployeeRequestDto){
        restaurantEmployeeHandler.save(restaurantEmployeeRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
