package org.springcloud.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author chiangfai
 * <p>
 *     服务消费
 *     方式一：restTemplate + ribbon
 *     方式二：fegin
 *     Ribbon是一个负载均衡客户端，可以很好的控制http和tcp的一些行为。
 *     Feign是一个声明性的web服务客户端，默认集成了ribbon
 * </p>
 **/
@EnableHystrixDashboard
//@EnableCircuitBreaker //开启断路器功能
@EnableFeignClients // 启用feign客户端
//@EnableDiscoveryClient //开启服务发现客户端
//@SpringBootApplication
/**
 * @SpringCloudApplication注解包含以下三个注解功能
 * @SpringBootApplication
 * @EnableDiscoveryClient
 * @EnableCircuitBreaker
 */
@SpringCloudApplication
public class EurekaConsumerApplication {


    @LoadBalanced //表示开启负载均衡的功能
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
}
