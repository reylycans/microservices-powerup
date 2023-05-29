package com.pragma.hexagonal.application.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RestaurantRequestDto {
    private Long id;
    @NotNull(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "nit is required")
    @NotBlank(message = "nit is required")
    private String nit;

    @NotNull(message = "address is required")
    @NotBlank(message = "address is required")
    private String address;

    @NotNull(message = "phone is required")
    @NotBlank(message = "phone is required")
    private String phone;

    @NotNull(message = "urlLogo is required")
    @NotBlank(message = "urlLogo is required")
    private String urlLogo;

    @NotNull(message = "ownerId is required")
    @NotBlank(message = "ownerId is required")
    private Long ownerId;
}
