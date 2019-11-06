package com.outfit.service;

import com.outfit.message.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestImpl implements Test1 {

    // == fields ==
    private final MessageGenerator messageGenerator;

    @Autowired
    public TestImpl(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }

    @Override
    public int getInt() {
        return 0;
    }
}
