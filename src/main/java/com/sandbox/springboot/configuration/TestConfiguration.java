package com.sandbox.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * oxibex@gmail.com
 * on 10.10.2019
 */
@Configuration
public class TestConfiguration {

    @Bean
    public YamlConfiguration getYamlConfiguration() {
        return new YamlConfiguration();
    }

}
