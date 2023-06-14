package com.pragma.hexagonal.infraestructure.port.out.feignclients;

import com.pragma.hexagonal.infraestructure.port.out.feignclients.dto.MessageFeignDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "twilio-service",url="localhost:8083/message/twilio")
public interface ITwilioFeignClient {

    @PostMapping
    void sendMessageTwilio(@Valid @RequestBody MessageFeignDto messageFeignDto);
}
