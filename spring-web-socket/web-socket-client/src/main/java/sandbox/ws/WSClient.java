package sandbox.ws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class WSClient {

    private static final int TIMER_DELAY =0;
    private static final int TIMER_REPEAT = 10000;

    public WSClient(String token) {

        WebSocketConnectionManager manager = new WebSocketConnectionManager(new StandardWebSocketClient(),
                new TextWebSocketHandler() {
                    @Override
                    public void afterConnectionEstablished(WebSocketSession session) {
                        log.info("ws open");
                        createTimer(session);
                    }

                    @Override
                    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
                        log.info("receive message {}" + message.getPayload());
                    }
                },
                "ws://debug.local/ws/web?token=" + token);
        manager.start();
    }

    private void createTimer(WebSocketSession session) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    log.info("Send message at session {} " + session.getId());
                    session.sendMessage(new TextMessage("X"));
                } catch (IOException e) {
                    log.error(e.toString());
                }
            }
        }, TIMER_DELAY, TIMER_REPEAT);
    }

}
