package com.sandbox.springboot.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * oxibex@gmail.com
 * on 10.10.2019
 */
@Component
@Slf4j
public class TestBeanToGetApplicationArguments {

    @Autowired
    public TestBeanToGetApplicationArguments(ApplicationArguments arguments) {
        log.info("Start bean class");
        log.info("Parameters from application arguments");
        //named argument
        boolean debug = arguments.containsOption("debug");
        log.info("debug " + debug);
        //non option
        List<String> files = arguments.getNonOptionArgs();
        for (String s: files) {
            log.info(s);
        }
    }
}
