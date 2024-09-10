package org.example.spring_demo_base_01.service;

import org.springframework.stereotype.Service;

@Service("greetings")

public class GreetingServiceEnglish implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello everyone !";
    }
}