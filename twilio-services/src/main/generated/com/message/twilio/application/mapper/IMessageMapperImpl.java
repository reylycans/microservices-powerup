package com.message.twilio.application.mapper;

import com.message.twilio.application.dto.MessageRequestDto;
import com.message.twilio.domain.model.MessageModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T15:05:08-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IMessageMapperImpl implements IMessageMapper {

    @Override
    public MessageModel toModel(MessageRequestDto messageRequestDto) {
        if ( messageRequestDto == null ) {
            return null;
        }

        MessageModel messageModel = new MessageModel();

        messageModel.setNumber( messageRequestDto.getNumber() );
        messageModel.setMessage( messageRequestDto.getMessage() );

        return messageModel;
    }
}
