package com.message.configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nchechenko
 * @since 16.10.2023
 */
@Configuration
public class MicrometerConfiguration {

    @Bean
    public MeterRegistry meterRegistry() {
        CompositeMeterRegistry compositeMeterRegistry = new CompositeMeterRegistry();
        return compositeMeterRegistry;
    }

}
