package com.pragma.usuarios.application.dto.response;

import com.pragma.usuarios.domain.model.RolModel;
import lombok.Data;


@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private Long identityDocument;
    private String cellPhone;
    private String email;
    private String password;
    private RolModel rol;
}
