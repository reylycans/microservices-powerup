package com.pragma.hexagonal.infraestructure.port.in.web;

import com.pragma.hexagonal.application.dto.request.CategoryRequestDto;
import com.pragma.hexagonal.application.handler.impl.CategoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryHandler categoryHandler;

    @Operation(summary = "add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "category created",content = @Content),
            @ApiResponse(responseCode = "409",description = "category already exists",content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CategoryRequestDto categoryRequestDto,
                                     BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        categoryHandler.save(categoryRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
