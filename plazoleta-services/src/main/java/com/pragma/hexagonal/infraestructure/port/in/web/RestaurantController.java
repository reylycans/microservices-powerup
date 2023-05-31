package com.pragma.hexagonal.infraestructure.port.in.web;

import com.pragma.hexagonal.application.dto.request.RestaurantRequestDto;
import com.pragma.hexagonal.application.dto.response.RestaurantResponseDto;
import com.pragma.hexagonal.application.handler.IRestaurantHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@AllArgsConstructor
public class RestaurantController {

    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "add a new restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "restaurant created",content = @Content),
            @ApiResponse(responseCode = "409",description = "restaurant already exists",content = @Content)
    })
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> save(@RequestBody RestaurantRequestDto restaurantRequestDto){
        restaurantHandler.save(restaurantRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "get restaurant by owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "get restaurant",content = @Content),
            @ApiResponse(responseCode = "404",description = "restaurant not found",content = @Content)
    })
    @GetMapping
    public ResponseEntity<RestaurantResponseDto> getRestaurantByOwner(@RequestParam(value = "ownerId") Long ownerId){
        return ResponseEntity.ok(restaurantHandler.getRestaurantByOwner(ownerId));
    }

    @Operation(summary = "get all restaurants with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "all restaurant returned paginated",content = @Content),
            @ApiResponse(responseCode = "404",description = "restaurants not found",content = @Content)
    })
    @GetMapping("/getAllRestaurantPagination")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurantPagination(@RequestParam(value = "page") Integer page,
                                                                                  @RequestParam(value = "size") Integer size){
        return ResponseEntity.ok(restaurantHandler.getAllRestaurantsWithPagination(page,size));
    }


}
