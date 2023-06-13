package com.pragma.hexagonal.infraestructure.port.out.feignclients.mapper;

import com.pragma.hexagonal.domain.model.UserModel;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.dto.UserFeignDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-13T12:49:05-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IUserFeignMapperImpl implements IUserFeignMapper {

    @Override
    public UserModel toModel(UserFeignDto userFeignDto) {
        if ( userFeignDto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userFeignDto.getId() );
        userModel.setName( userFeignDto.getName() );
        userModel.setLastName( userFeignDto.getLastName() );
        if ( userFeignDto.getIdentityDocument() != null ) {
            userModel.setIdentityDocument( Long.parseLong( userFeignDto.getIdentityDocument() ) );
        }
        userModel.setCellPhone( userFeignDto.getCellPhone() );
        userModel.setPassword( userFeignDto.getPassword() );
        userModel.setRol( userFeignDto.getRol() );
        userModel.setEmail( userFeignDto.getEmail() );

        return userModel;
    }
}
