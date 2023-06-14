package com.message.twilio.domain.port.out;

import com.message.twilio.domain.model.MessageModel;

public interface IMessageRepository {
    void sendSmsMessage(MessageModel messageModel);
}
