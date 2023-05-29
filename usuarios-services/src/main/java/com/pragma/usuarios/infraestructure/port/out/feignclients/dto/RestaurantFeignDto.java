package com.pragma.usuarios.infraestructure.port.out.feignclients.dto;

import lombok.Data;

@Data
public class RestaurantFeignDto {
    private Long id;
    private String name;
    private String nit;
    private String address;
    private String phone;
    private String urlLogo;
    private Long ownerId;
}
