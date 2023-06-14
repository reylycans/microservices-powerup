package com.message.twilio.infraestructure.config;

import com.message.twilio.domain.port.in.IMessageServicePort;
import com.message.twilio.domain.port.out.IMessageRepository;
import com.message.twilio.domain.service.MessageServicePort;
import com.message.twilio.infraestructure.port.out.adapter.MessageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IMessageServicePort messageServicePort(IMessageRepository messageRepository){
        return new MessageServicePort(messageRepository);
    }
    @Bean
    public IMessageRepository messageRepository(){
        return new MessageRepository();
    }
}
