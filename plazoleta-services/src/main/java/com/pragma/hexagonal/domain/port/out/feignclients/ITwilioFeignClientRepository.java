package com.pragma.hexagonal.domain.port.out.feignclients;

import com.pragma.hexagonal.domain.model.MessageModel;

public interface ITwilioFeignClientRepository {
    void sendMessageTwilio(MessageModel messageModel);
}
