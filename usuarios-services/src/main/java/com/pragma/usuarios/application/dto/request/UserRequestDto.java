package com.pragma.usuarios.application.dto.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserRequestDto {

    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    @Size(min = 2,message = "the name must have at least 2 characters")
    private String name;

    @NotNull(message = "lastName is required")
    @NotEmpty(message = "lastName is required")
    private String lastName;

    @NotNull(message = "identityDocument is required")
    @NotEmpty(message = "identityDocument is required")
    private Long identityDocument;

    @Pattern(regexp = "^\\+?\\d{1,12}$", message = "The mobile number can contain a maximum of 13 characters and can contain the + symbol")
    private String cellPhone;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "email must be valid")
    private String email;

    @NotNull(message = "password is required")
    @NotEmpty(message = "password is required")
    private String password;
    private RolRequestDto rol;
}
