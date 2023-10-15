package com.sandbox.microservice.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestServiceApplication {

    public static void main(String[] args) {
        new SpringApplication(TestServiceApplication.class).run(args);
    }
}
