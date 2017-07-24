package com.reggie.snow.testkit;

import com.reggie.snow.SnowWebApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by didi on 17/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SnowWebApplication.class)
@WebIntegrationTest
public class IntegrationTest {

    private RestTemplate restTemplate = new TestRestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}
