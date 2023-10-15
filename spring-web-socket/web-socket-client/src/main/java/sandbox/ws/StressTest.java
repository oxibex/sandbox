package sandbox.ws;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import sandbox.ws.service.WSService;

public class StressTest {

    private WSService wsService;

    @Autowired
    public void setWsService(WSService wsService) {
        this.wsService = wsService;
    }

    @PostConstruct
    public void initStress() {
        for (int i = 0; i < 200; i++) {
            wsService.createClientAndConnect("admin", "admin");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }
}
