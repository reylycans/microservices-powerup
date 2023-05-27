package com.pragma.usuarios.infraestructure.port.in.web;

import com.pragma.usuarios.application.dto.request.RolRequestDto;
import com.pragma.usuarios.application.handler.IRolHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/rol")
@AllArgsConstructor
public class RolController {

    private final IRolHandler rolHandler;

    @Operation(summary = "add a new rol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "rol created",content = @Content),
            @ApiResponse(responseCode = "409",description = "rol already exists",content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody RolRequestDto rolRequestDto){
        rolHandler.save(rolRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
