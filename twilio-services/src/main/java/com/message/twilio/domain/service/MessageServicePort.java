package com.message.twilio.domain.service;

import com.message.twilio.domain.model.MessageModel;
import com.message.twilio.domain.port.in.IMessageServicePort;
import com.message.twilio.domain.port.out.IMessageRepository;

public class MessageServicePort implements IMessageServicePort {

    private final IMessageRepository messageRepository;

    public MessageServicePort(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void sendSmsMessage(MessageModel messageModel) {
        messageRepository.sendSmsMessage(messageModel);
    }
}
