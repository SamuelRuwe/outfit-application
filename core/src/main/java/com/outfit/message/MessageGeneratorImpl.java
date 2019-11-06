package com.outfit.message;

import org.springframework.stereotype.Component;

@Component
public class MessageGeneratorImpl implements MessageGenerator{

    public MessageGeneratorImpl() {
    }

    @Override
    public String getMainMessage() {
        return "main message";
    }

    @Override
    public String getResultMessage() {
        return "result message";
    }
}
