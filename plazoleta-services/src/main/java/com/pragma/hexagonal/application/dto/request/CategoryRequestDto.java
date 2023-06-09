package com.pragma.hexagonal.application.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CategoryRequestDto {
    private Long id;

    @NotNull(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "description is required")
    @NotBlank(message = "description is required")
    private String description;
}
