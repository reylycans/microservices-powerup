package com.pragma.usuarios.application.mapper.response;

import com.pragma.usuarios.application.dto.response.UserResponseDto;
import com.pragma.usuarios.domain.model.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T11:52:11-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IUserResponseMapperImpl implements IUserResponseMapper {

    @Override
    public UserResponseDto toResponse(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setRol( userModel.getRol() );
        userResponseDto.setId( userModel.getId() );
        userResponseDto.setName( userModel.getName() );
        userResponseDto.setLastName( userModel.getLastName() );
        userResponseDto.setIdentityDocument( userModel.getIdentityDocument() );
        userResponseDto.setCellPhone( userModel.getCellPhone() );
        userResponseDto.setEmail( userModel.getEmail() );
        userResponseDto.setPassword( userModel.getPassword() );

        return userResponseDto;
    }
}
