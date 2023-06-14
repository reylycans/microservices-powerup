package com.pragma.hexagonal.infraestructure.port.out.feignclients.mapper;

import com.pragma.hexagonal.domain.model.MessageModel;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.dto.MessageFeignDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T15:46:35-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IMessageFeignMapperImpl implements IMessageFeignMapper {

    @Override
    public MessageFeignDto toFeign(MessageModel messageModel) {
        if ( messageModel == null ) {
            return null;
        }

        MessageFeignDto messageFeignDto = new MessageFeignDto();

        messageFeignDto.setNumber( messageModel.getNumber() );
        messageFeignDto.setMessage( messageModel.getMessage() );

        return messageFeignDto;
    }
}
