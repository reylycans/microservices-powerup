package com.pragma.usuarios.infraestructure.port.out.mapper;

import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.infraestructure.port.out.entity.RolEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T17:58:00-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IRolEntityMapperImpl implements IRolEntityMapper {

    @Override
    public RolEntity toEntity(RolModel rolModel) {
        if ( rolModel == null ) {
            return null;
        }

        RolEntity rolEntity = new RolEntity();

        rolEntity.setId( rolModel.getId() );
        rolEntity.setName( rolModel.getName() );
        rolEntity.setDescription( rolModel.getDescription() );

        return rolEntity;
    }

    @Override
    public RolModel toModel(RolEntity rolEntity) {
        if ( rolEntity == null ) {
            return null;
        }

        RolModel rolModel = new RolModel();

        rolModel.setId( rolEntity.getId() );
        rolModel.setName( rolEntity.getName() );
        rolModel.setDescription( rolEntity.getDescription() );

        return rolModel;
    }
}
