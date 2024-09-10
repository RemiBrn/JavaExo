package org.example.spring_demo_base_01.service;

import org.springframework.stereotype.Service;

@Service("salutations")

public class GreetingServiceFrench implements GreetingService{
    @Override
    public String sayHello() {
        return "Bonjour tout le monde !";
    }
}
