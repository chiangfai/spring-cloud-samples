package org.springcloud.configclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author chiangfai
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigServerApplication.class)
@WebAppConfiguration
public class ConfigServerApplicationTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void get() {
        ResponseEntity<Map> responseEntity = new TestRestTemplate().getForEntity("http://127.0.0.1:5555/test/dev", Map.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        log.info(responseEntity.getBody().toString());
    }
}