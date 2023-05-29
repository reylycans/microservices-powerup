package com.pragma.hexagonal.infraestructure.port.in.web;

import com.pragma.hexagonal.application.dto.request.DishRequestDto;
import com.pragma.hexagonal.application.dto.request.DishUpdateRequestDto;
import com.pragma.hexagonal.application.handler.impl.DishHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/dish")
@AllArgsConstructor
public class DishController {

    private final DishHandler dishHandler;

    @Operation(summary = "add a new dish")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "dish created",content = @Content),
            @ApiResponse(responseCode = "409",description = "dish already exists",content = @Content)
    })
    @PostMapping
    @PreAuthorize("hasAuthority('OWNER')")
    public ResponseEntity<Void> save(@Valid @RequestBody DishRequestDto dishRequestDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        dishHandler.save(dishRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "update dish by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "dish updated",content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404",description = "data not found",content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",description = "invalid structure",content = @Content(mediaType = "application/json"))
    })
    @PutMapping
    @PreAuthorize("hasAuthority('OWNER')")
    public ResponseEntity<Void> update(@RequestParam(value = "dishId") Long dishId,
                                       @Valid @RequestBody DishUpdateRequestDto dishUpdateRequestDto,BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        dishHandler.update(dishId,dishUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "update dish enable or disable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "dish updated",content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404",description = "data not found",content = @Content(mediaType = "application/json"))
    })
    @PutMapping("/enableOrDisable")
    @PreAuthorize("hasAuthority('OWNER')")
    public ResponseEntity<Void> updateDishEnableOrDisable(@RequestParam(value = "dishId") Long dishId,
                                                          @RequestParam(value = "asset") Boolean asset){

        dishHandler.dishUpdateEnableOrDisable(dishId,asset);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
