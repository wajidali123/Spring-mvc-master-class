package org.johnpc.spring.mvc.demo.service.impl;

import org.johnpc.spring.mvc.demo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @Created By JohnPC
 */

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String getHelloMessage(String user) {

        return "Hello "+ user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to the demo application!";
    }
}
