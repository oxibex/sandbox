package com.sandbox.springboot;

import com.sandbox.springboot.listeners.ApplicationReadyEventListener;
import com.sandbox.springboot.listeners.ApplicationStartEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * oxibex@gmail.com
 * on 10.10.2019
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(
                new ApplicationStartEventListener(),
                new ApplicationReadyEventListener()
        );
        application.run(args);
    }

}
