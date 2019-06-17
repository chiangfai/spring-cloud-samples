package org.springcloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chiangfai
 **/

/**
 * <p>
 *     @EnableDiscoveryClient
 *     @EnableEurekaClient
 *     spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），
 *     @EnableDiscoveryClient基于spring-cloud-commons,
 *     @EnableEurekaClient基于spring-cloud-netflix。
 *     简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，
 *     如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
 * </p>
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
