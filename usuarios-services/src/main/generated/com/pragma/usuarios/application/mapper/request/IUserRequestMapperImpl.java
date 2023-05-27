package com.pragma.usuarios.application.mapper.request;

import com.pragma.usuarios.application.dto.request.RolRequestDto;
import com.pragma.usuarios.application.dto.request.UserRequestDto;
import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.model.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T17:58:00-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IUserRequestMapperImpl implements IUserRequestMapper {

    @Override
    public UserModel toUser(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setRol( rolRequestDtoToRolModel( userRequestDto.getRol() ) );
        userModel.setName( userRequestDto.getName() );
        userModel.setLastName( userRequestDto.getLastName() );
        userModel.setIdentityDocument( userRequestDto.getIdentityDocument() );
        userModel.setCellPhone( userRequestDto.getCellPhone() );
        userModel.setEmail( userRequestDto.getEmail() );
        userModel.setPassword( userRequestDto.getPassword() );

        return userModel;
    }

    protected RolModel rolRequestDtoToRolModel(RolRequestDto rolRequestDto) {
        if ( rolRequestDto == null ) {
            return null;
        }

        RolModel rolModel = new RolModel();

        rolModel.setId( rolRequestDto.getId() );
        rolModel.setName( rolRequestDto.getName() );
        rolModel.setDescription( rolRequestDto.getDescription() );

        return rolModel;
    }
}
