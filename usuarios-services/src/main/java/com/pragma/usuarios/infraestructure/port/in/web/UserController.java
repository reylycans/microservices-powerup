package com.pragma.usuarios.infraestructure.port.in.web;

import com.pragma.usuarios.application.dto.UserRequestDto;
import com.pragma.usuarios.application.handler.IUserHandler;
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
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Void> save(@Valid @RequestBody UserRequestDto userRequestDto){
        userHandler.save(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
