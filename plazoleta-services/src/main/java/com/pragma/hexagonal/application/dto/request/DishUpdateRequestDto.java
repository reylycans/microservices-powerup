package com.pragma.hexagonal.application.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
@Data
public class DishUpdateRequestDto {
    @NotNull(message = "price is required")
    //@Pattern(regexp = "^[1-9]\\d*$", message = "price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "description is required")
    @NotBlank(message = "description is required")
    private String description;
}
