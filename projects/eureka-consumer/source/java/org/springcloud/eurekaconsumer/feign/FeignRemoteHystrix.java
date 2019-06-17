package org.springcloud.eurekaconsumer.feign;

import org.springframework.stereotype.Component;

/**
 * @author chiangfai
 **/
@Component
public class FeignRemoteHystrix implements FeignRemote{

    @Override
    public String hi(String param) {
        return "熔断 fallback info. + param = " + param;
    }
}
