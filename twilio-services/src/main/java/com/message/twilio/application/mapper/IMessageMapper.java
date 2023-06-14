package com.message.twilio.application.mapper;

import com.message.twilio.application.dto.MessageRequestDto;
import com.message.twilio.domain.model.MessageModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMessageMapper {
    MessageModel toModel(MessageRequestDto messageRequestDto);
}
