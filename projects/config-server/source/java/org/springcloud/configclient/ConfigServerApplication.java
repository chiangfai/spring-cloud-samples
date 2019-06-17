package org.springcloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author chiangfai
 **/
@EnableDiscoveryClient // 标识服务提供方
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
        //new SpringApplicationBuilder(ConfigServerApplication.class).web(true).run(args);
        //new SpringApplicationBuilder(ConfigServerApplication.class).web(WebApplicationType.NONE).run(args);
    }
}
