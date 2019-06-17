package org.springcloud.configclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chiangfai
 **/
@RefreshScope
@RestController
public class HiController {

    @Value("${test.hi}")
    private String hiStr;

    @ResponseBody
    @GetMapping("/hi")
    public String hi() {
        return hiStr;
    }
}
