package com.pragma.usuarios.infraestructure.port.out.mapper;

import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.infraestructure.port.out.entity.RolEntity;
import com.pragma.usuarios.infraestructure.port.out.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-25T22:25:11-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IUserEntityMapperImpl implements IUserEntityMapper {

    @Override
    public UserModel toUserModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setRol( rolEntityToRolModel( userEntity.getRol() ) );
        userModel.setId( userEntity.getId() );
        userModel.setName( userEntity.getName() );
        userModel.setLastName( userEntity.getLastName() );
        userModel.setIdentityDocument( userEntity.getIdentityDocument() );
        userModel.setCellPhone( userEntity.getCellPhone() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setPassword( userEntity.getPassword() );

        return userModel;
    }

    @Override
    public UserEntity toEntity(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModel.getId() );
        userEntity.setName( userModel.getName() );
        userEntity.setLastName( userModel.getLastName() );
        userEntity.setIdentityDocument( userModel.getIdentityDocument() );
        userEntity.setCellPhone( userModel.getCellPhone() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setRol( rolModelToRolEntity( userModel.getRol() ) );

        return userEntity;
    }

    protected RolModel rolEntityToRolModel(RolEntity rolEntity) {
        if ( rolEntity == null ) {
            return null;
        }

        RolModel rolModel = new RolModel();

        rolModel.setId( rolEntity.getId() );
        rolModel.setName( rolEntity.getName() );
        rolModel.setDescription( rolEntity.getDescription() );

        return rolModel;
    }

    protected RolEntity rolModelToRolEntity(RolModel rolModel) {
        if ( rolModel == null ) {
            return null;
        }

        RolEntity rolEntity = new RolEntity();

        rolEntity.setId( rolModel.getId() );
        rolEntity.setName( rolModel.getName() );
        rolEntity.setDescription( rolModel.getDescription() );

        return rolEntity;
    }
}
