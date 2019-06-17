package net.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author chiangfai
 * <p>
 *     Zuul是Netflix出品的一个基于JVM路由和服务端的负载均衡器。
 *     提供动态路由、监控、弹性、安全等边缘服务。
 *     Zuul核心是Filter
 *
 *     注：
 *     Spring Cloud中，Zuul绝大部分功能都是Spring Cloud团队为Zuul开发的
 *     所以Zuul 2.x的开源进度延后一年，Spring Cloud团队开发了自己的Spring Cloud Gateway，
 *     并宣布Spring Cloud不打算支持Zuul 2.x
 * </p>
 **/
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
