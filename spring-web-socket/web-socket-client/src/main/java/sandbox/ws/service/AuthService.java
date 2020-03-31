package sandbox.ws.service;

import sandbox.ws.dto.AuthRequestDto;

public interface AuthService {

    String getToken(AuthRequestDto requestDto);
}
