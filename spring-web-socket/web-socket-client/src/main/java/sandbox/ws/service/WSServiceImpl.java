package sandbox.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sandbox.ws.WSClient;
import sandbox.ws.dto.AuthRequestDto;

@Service
public class WSServiceImpl implements WSService {

    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public WSClient createClientAndConnect(String login, String password) {
        String token = authService.getToken(new AuthRequestDto(login, password));
        if(token != null) {
            WSClient wsClient = new WSClient(token);
            return wsClient;
        }
        return null;
    }
}
