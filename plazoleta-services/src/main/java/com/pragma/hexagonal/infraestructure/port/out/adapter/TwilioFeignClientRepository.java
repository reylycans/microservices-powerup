package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.MessageModel;
import com.pragma.hexagonal.domain.port.out.feignclients.ITwilioFeignClientRepository;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.ITwilioFeignClient;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.mapper.IMessageFeignMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TwilioFeignClientRepository implements ITwilioFeignClientRepository {

    private final ITwilioFeignClient twilioFeignClient;
    private final IMessageFeignMapper messageFeignMapper;

    @Override
    public void sendMessageTwilio(MessageModel messageModel) {
         twilioFeignClient.sendMessageTwilio(messageFeignMapper.toFeign(messageModel));
    }
}
