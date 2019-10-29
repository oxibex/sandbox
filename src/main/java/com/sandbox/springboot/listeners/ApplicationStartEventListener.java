package com.sandbox.springboot.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * oxibex@gmail.com
 * on 29.10.2019
 */
@Slf4j
public class ApplicationStartEventListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("Start Application event");
        log.debug("All bean definition names");
        for (String beanName : event.getApplicationContext().getBeanDefinitionNames()){
            log.debug(beanName);
        }
    }
}
