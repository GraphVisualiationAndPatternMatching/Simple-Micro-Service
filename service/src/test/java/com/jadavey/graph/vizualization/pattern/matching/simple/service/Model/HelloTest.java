package com.jadavey.graph.vizualization.pattern.matching.simple.service.Model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloTest {

    @Test
    public void checkCorrectMessageIsProduced() {
        Hello testObject = new Hello();
        assertThat(testObject.sayHello()).isEqualToIgnoringCase("Hello world!");
    }
}
