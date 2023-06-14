package com.message.twilio.application.handler;

import com.message.twilio.application.dto.MessageRequestDto;

public interface IMessageHandler {
    void sendSmsMessage(MessageRequestDto messageRequestDto);
}
