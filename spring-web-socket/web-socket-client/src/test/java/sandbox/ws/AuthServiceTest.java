package sandbox.ws;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sandbox.ws.dto.AuthRequestDto;
import sandbox.ws.service.AuthService;
import sandbox.ws.service.AuthServiceImpl;

class AuthServiceTest {

    @Test
    public void sentAuthRequest() {
        AuthService authService = new AuthServiceImpl();
        AuthRequestDto authRequestDto = new AuthRequestDto("admin","admin");

        String token = authService.getToken(authRequestDto);
        Assert.assertNotNull(token);
        System.out.println("Token " + token);
    }
}