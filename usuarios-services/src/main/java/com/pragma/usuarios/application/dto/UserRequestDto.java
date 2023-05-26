package com.pragma.usuarios.application.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String lastName;
    private String identityDocument;
    private String cellPhone;
    private String email;
    private String password;
    private RolRequestDto rol;
}
