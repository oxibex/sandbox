package sandbox.springboot.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Test to get start parameters
 * oxibex@gmail.com
 * on 16.10.2019
 */
@Component
@Slf4j
public class TestCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        log.info("****** Arguments from line runner ******");
        for(String s: args) {
            log.info(s);
        }
    }
}
