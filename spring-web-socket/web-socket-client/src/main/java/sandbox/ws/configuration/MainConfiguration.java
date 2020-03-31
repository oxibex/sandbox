package sandbox.ws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sandbox.ws.StressTest;

@Configuration
public class MainConfiguration {

    @Bean
    public StressTest stressTest() {
        return new StressTest();
    }

}
