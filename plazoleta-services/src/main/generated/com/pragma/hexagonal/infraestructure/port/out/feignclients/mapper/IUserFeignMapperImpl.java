package com.pragma.hexagonal.infraestructure.port.out.feignclients.mapper;

import com.pragma.hexagonal.domain.model.UserModel;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.dto.UserFeignDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T13:43:08-0500",
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
        userModel.setIdentityDocument( userFeignDto.getIdentityDocument() );
        userModel.setCellPhone( userFeignDto.getCellPhone() );
        userModel.setPassword( userFeignDto.getPassword() );
        userModel.setRol( userFeignDto.getRol() );

        return userModel;
    }
}
