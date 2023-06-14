package com.message.twilio.infraestructure.port.out.adapter;

import com.message.twilio.domain.model.MessageModel;
import com.message.twilio.domain.port.out.IMessageRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

public class MessageRepository implements IMessageRepository {

    @Value("${TWILIO_ACCOUNT_SID}")
    private String ACCOUNT_SID;
    @Value("${TWILIO_AUTH_TOKEN}")
    private String AUTH_TOKEN;
    @Value("${TWILIO_FROM_PHONE_NUMBER}")
    private String FROM_PHONE_NUMBER;

    @Override
    public void sendSmsMessage(MessageModel messageModel) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber(messageModel.getNumber()),
                        new PhoneNumber(FROM_PHONE_NUMBER),
                        messageModel.getMessage()).
                create();

        System.out.println(message.getSid());
    }
}
