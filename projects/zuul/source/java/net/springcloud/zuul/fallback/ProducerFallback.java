package net.springcloud.zuul.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author chiangfai
 * <p>
 *     zuul实现路由熔断拦截
 * </p>
 **/
@Component
public class ProducerFallback implements FallbackProvider {
    /**
     * 表明熔断拦截哪个服务， * 表示为所有服务提供回退。
     * @return serviceId
     */
    @Override
    public String getRoute() {
        return "eureka-producer";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return cause instanceof HystrixTimeoutException ? fallbackResponse(HttpStatus.GATEWAY_TIMEOUT) : this.fallbackResponse();
    }

    public ClientHttpResponse fallbackResponse() {
        return this.fallbackResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ClientHttpResponse fallbackResponse(final HttpStatus httpStatus) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return httpStatus;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return httpStatus.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return httpStatus.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("The service is unavailable.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mediaType);
                return headers;
            }
        };
    }
}
