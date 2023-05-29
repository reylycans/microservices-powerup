package com.pragma.usuarios.infraestructure.port.out.feignclients.dto;

import lombok.Data;

@Data
public class RestaurantEmployeeFeignDto {
    private Long id;
    private RestaurantFeignDto restaurant;
    private Long userId;
}
