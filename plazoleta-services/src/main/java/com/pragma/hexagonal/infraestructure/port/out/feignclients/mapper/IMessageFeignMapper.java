package com.pragma.hexagonal.infraestructure.port.out.feignclients.mapper;

import com.pragma.hexagonal.domain.model.MessageModel;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.dto.MessageFeignDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMessageFeignMapper {
    MessageFeignDto toFeign(MessageModel messageModel);
}
