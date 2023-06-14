package com.message.twilio.application.handler.impl;

import com.message.twilio.application.dto.MessageRequestDto;
import com.message.twilio.application.handler.IMessageHandler;
import com.message.twilio.application.mapper.IMessageMapper;
import com.message.twilio.domain.model.MessageModel;
import com.message.twilio.domain.port.in.IMessageServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageHandler implements IMessageHandler {

    private final IMessageServicePort messageServicePort;
    private final IMessageMapper messageMapper;

    @Override
    public void sendSmsMessage(MessageRequestDto messageRequestDto) {
        MessageModel messageModel = messageMapper.toModel(messageRequestDto);
        messageServicePort.sendSmsMessage(messageModel);
    }
}
