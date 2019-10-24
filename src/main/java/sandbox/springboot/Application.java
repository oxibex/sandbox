package sandbox.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sandbox.springboot.listeners.ApplicationReadyEventListener;

/**
 * oxibex@gmail.com
 * on 10.10.2019
 */
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationReadyEventListener());
        application.run(args);

    }

}
