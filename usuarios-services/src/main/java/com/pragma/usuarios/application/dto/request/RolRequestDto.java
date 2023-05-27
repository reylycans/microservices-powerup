package com.pragma.usuarios.application.dto.request;

import lombok.Data;

@Data
public class RolRequestDto {
    private Long id;
    private String name;
    private String description;
}
