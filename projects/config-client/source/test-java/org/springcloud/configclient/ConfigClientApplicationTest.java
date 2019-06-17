package org.springcloud.configclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author chiangfai
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigClientApplication.class)
@WebAppConfiguration
public class ConfigClientApplicationTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void refresh() {
        // postman test http://localhost:5556/actuator/bus-refresh
        String url = "http://localhost:5556/actuator/bus-refresh";
        ResponseEntity<Map> responseEntity = new TestRestTemplate().exchange(url, HttpMethod.POST, null, Map.class);
        // 204
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}