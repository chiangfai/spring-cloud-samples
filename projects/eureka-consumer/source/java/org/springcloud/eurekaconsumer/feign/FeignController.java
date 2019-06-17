package org.springcloud.eurekaconsumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chiangfai
 **/
@RestController
public class FeignController {

    @Autowired
    private FeignRemote feignRemote;

    @RequestMapping("/feign/hi")
    public String feign() {
        return feignRemote.hi("我使用feign调用服务");
    }
}
