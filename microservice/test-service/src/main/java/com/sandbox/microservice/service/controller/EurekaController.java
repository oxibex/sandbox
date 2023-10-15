package com.sandbox.microservice.service.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import com.sandbox.microservice.service.dto.ServiceDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class EurekaController {

    @Value("${test.property}")
    private Integer testProperty;

    private final DiscoveryClient discoveryClient;

    public EurekaController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @PostConstruct
    public void init(){
        log.info("Test property from congif server {}", this.testProperty);
    }

    @GetMapping(path = "/services")
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
