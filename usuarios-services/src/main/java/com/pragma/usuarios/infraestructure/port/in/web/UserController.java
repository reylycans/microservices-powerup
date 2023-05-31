package com.pragma.usuarios.infraestructure.port.in.web;

import com.pragma.usuarios.application.dto.request.UserRequestDto;
import com.pragma.usuarios.application.dto.response.UserResponseDto;
import com.pragma.usuarios.application.handler.IUserHandler;
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
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

    private final IUserHandler userHandler;


    @Operation(summary = "add a new owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "owner created",content = @Content),
            @ApiResponse(responseCode = "409",description = "owner already exists",content = @Content)
    })
    @PostMapping("/owner")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> save(@Valid @RequestBody UserRequestDto userRequestDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userHandler.save(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "add a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "owner created",content = @Content),
            @ApiResponse(responseCode = "409",description = "owner already exists",content = @Content)
    })
    @PostMapping("/employee")
    @PreAuthorize("hasAuthority('OWNER')")
    public ResponseEntity<Void> saveEmployee(@Valid @RequestBody UserRequestDto userRequestDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userHandler.saveEmployee(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "get user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "user returned",content = @Content),
            @ApiResponse(responseCode = "404",description = "user not foud",content = @Content)
    })
    @GetMapping
    public ResponseEntity<UserResponseDto> getUserById(@RequestParam(value = "userId") Long userId){
        return ResponseEntity.ok(userHandler.getUserById(userId));
    }

    @Operation(summary = "get user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "user returned",content = @Content),
            @ApiResponse(responseCode = "404",description = "user not foud",content = @Content)
    })
    @GetMapping("/userByEmail")
    public ResponseEntity<UserResponseDto> getUserByEmail(@RequestParam(value = "email") String email){
        return ResponseEntity.ok(userHandler.getUserByEmail(email));
    }

    @Operation(summary = "add a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "customer created",content = @Content),
            @ApiResponse(responseCode = "409",description = "customer already exists",content = @Content)
    })
    @PostMapping("/customer")
    public ResponseEntity<Void> saveCustomer(@Valid @RequestBody UserRequestDto userRequestDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userHandler.save(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
