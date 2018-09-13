package com.example.demo;

import javax.xml.ws.Endpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {
    @Bean
    public UserService userService()
    {
        return  new UserServiceImpl();
    }
    @Bean
    public Endpoint endpoint() {
    	
       return Endpoint.publish("http://localhost:8000/services/aa", userService());
    }
}