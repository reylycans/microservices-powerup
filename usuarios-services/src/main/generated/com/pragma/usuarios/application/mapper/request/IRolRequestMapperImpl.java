package com.pragma.usuarios.application.mapper.request;

import com.pragma.usuarios.application.dto.request.RolRequestDto;
import com.pragma.usuarios.domain.model.RolModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T17:27:57-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IRolRequestMapperImpl implements IRolRequestMapper {

    @Override
    public RolModel toRol(RolRequestDto rolRequestDto) {
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
