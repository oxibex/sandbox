package com.sandbox.springboot.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * oxibex@gmail.com
 * on 29.10.2019
 */
@Slf4j
@EnableConfigurationProperties(YamlConfiguration.class)
@ConfigurationProperties(prefix = "my")
public class YamlConfiguration {

    private List<String> servers;

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    @PostConstruct
    public void init() {
        log.info("Load from yaml");
        servers.forEach(server -> log.info(server));
    }

}
