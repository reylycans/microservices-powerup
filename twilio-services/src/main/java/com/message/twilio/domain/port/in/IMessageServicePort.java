package com.message.twilio.domain.port.in;

import com.message.twilio.domain.model.MessageModel;

public interface IMessageServicePort {
    void sendSmsMessage(MessageModel messageModel);
}
