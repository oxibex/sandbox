package sandbox.ws.service;

import sandbox.ws.WSClient;

public interface WSService {

    WSClient createClientAndConnect(String login, String password);

}
