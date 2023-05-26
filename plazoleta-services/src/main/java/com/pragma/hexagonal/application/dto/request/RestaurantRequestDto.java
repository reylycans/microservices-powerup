package com.pragma.hexagonal.application.dto.request;

import lombok.Data;

@Data
public class RestaurantRequestDto {
    private Long id;
    private String name;
    private String nit;
    private String address;
    private String phone;
    private String urlLogo;
    private Long userId;
}
