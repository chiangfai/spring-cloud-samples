package org.springcloud.eurekaconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chiangfai
 **/
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String consumer() {
        String url = "http://eureka-producer/hi?param={1}";
        return restTemplate.getForObject(url, String.class, "我来调用服务");
    }
}
