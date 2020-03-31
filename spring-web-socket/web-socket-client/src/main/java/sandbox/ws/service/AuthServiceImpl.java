package sandbox.ws.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sandbox.ws.dto.AuthRequestDto;
import sandbox.ws.dto.AuthResponseDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private String url = "http://debug.local/rest/authenticate";

    @Override
    public String getToken(AuthRequestDto requestDto) {
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(mappingJackson2HttpMessageConverter);
        messageConverters.add(new StringHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application","json"));
        HttpEntity<AuthRequestDto> httpEntity = new HttpEntity<>(requestDto, requestHeaders);

        AuthResponseDto responseEntity = restTemplate.postForObject(url, httpEntity, AuthResponseDto.class);
        return responseEntity.getToken();
    }
}
