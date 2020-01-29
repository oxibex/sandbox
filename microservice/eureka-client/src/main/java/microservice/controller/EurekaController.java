package microservice.controller;

import microservice.dto.ServiceDto;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EurekaController {

    private final DiscoveryClient discoveryClient;

    public EurekaController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping(path = "services")
    public List<ServiceDto> getAvailableClients() {
        List<String> services = discoveryClient.getServices();
        List<ServiceDto> res = new ArrayList<>();
        for (String serviceId : services) {
            ServiceDto serviceDto = new ServiceDto();
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            for (ServiceInstance instance : instances) {
                serviceDto.setServiceId(instance.getServiceId());
                serviceDto.setUri(instance.getUri().toString());
                serviceDto.setHost(instance.getHost());
                serviceDto.setPort(instance.getPort());
                res.add(serviceDto);
            }
        }
        return res;
    }
}
