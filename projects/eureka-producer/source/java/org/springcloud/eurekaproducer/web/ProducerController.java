package org.springcloud.eurekaproducer.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chiangfai
 **/
@RestController
public class ProducerController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String hi(String param) {
        return "port: " + port +" say : hi, spring cloud. param = " + param;
    }
}
