package org.springcloud.eurekaconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chiangfai
 **/

/**
 * name：注册中心服务供应商的服务名
 * fallback：服务熔断的时候返回fallback类中的内容
 */
@FeignClient(name = "eureka-producer", fallback = FeignRemoteHystrix.class)
public interface FeignRemote {

    @RequestMapping("/hi")
    String hi(@RequestParam(name = "param") String param);
}
