package microservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDto {

    private String serviceId;
    private String uri;
    private String host;
    private Integer port;

}
