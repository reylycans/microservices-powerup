package com.pragma.hexagonal.infraestructure.port.in.web;

import com.pragma.hexagonal.application.dto.request.OrderRequestDto;
import com.pragma.hexagonal.application.dto.response.OrderResponseDto;
import com.pragma.hexagonal.application.handler.IOrderHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderHandler orderHandler;

    @Operation(summary = "save order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "save order",content = @Content),
            @ApiResponse(responseCode = "400",description = "there is an order in pending status",content = @Content)
    })
    @PostMapping
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<Void> save(@Valid @RequestBody OrderRequestDto orderRequestDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderHandler.save(orderRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "get all order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "gell all order",content = @Content),
            @ApiResponse(responseCode = "400",description = "there is no existing order",content = @Content)
    })
    @GetMapping
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public ResponseEntity<List<OrderResponseDto>> getAllOrderWithPagination(@RequestParam(value = "page") Integer page,
                                                          @RequestParam(value = "size") Integer size,
                                                          @RequestParam(value = "state") String state){
        return ResponseEntity.ok(orderHandler.getAllOrderWithPagination(page,size,state));
    }

    @Operation(summary = "take order for employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "take order",content = @Content),
            @ApiResponse(responseCode = "400",description = "order not found",content = @Content)
    })
    @PutMapping
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public ResponseEntity<Void> takeOrderForEmployee(@RequestParam(value = "orderId") Long orderId,
                                                     @RequestParam(value = "state") String state){
        orderHandler.takeOrderForEmployee(orderId,state);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
