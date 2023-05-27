package com.pragma.hexagonal.infraestructure.port.out.feignclients.dto;

import com.pragma.hexagonal.domain.model.RolModel;
import lombok.Data;

@Data
public class UserFeignDto {
    private Long id;
    private String name;
    private String lastName;
    private String identityDocument;
    private String cellPhone;
    private String email;
    private String password;
    private RolModel rol;
}
