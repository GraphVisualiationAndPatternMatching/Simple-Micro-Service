package com.jadavey.graph.vizualization.pattern.matching.simple.acceptance.HelloController;

import com.jadavey.graph.vizualization.pattern.matching.simple.acceptance.util.SetupHelpers;
import com.mashape.unirest.http.Unirest;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class HelloTest {

    private String serviceUrl;
    @Before
    public void setUp() {
       Optional<String> potentialServiceUrl = SetupHelpers.getServiceUrl();
       if(potentialServiceUrl.isPresent()) {
           serviceUrl = potentialServiceUrl.get();
       } else {
           throw new IllegalStateException("no service url defined");
       }
    }

    @Test
    public void checkHelloControllerWorks() throws Exception {
        String response = Unirest.get(serviceUrl).asString().getBody();
        assertThat(response).isEqualTo("Hello world!");
    }

}
