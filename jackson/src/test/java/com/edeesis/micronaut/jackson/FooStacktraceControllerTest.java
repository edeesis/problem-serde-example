package com.edeesis.micronaut.jackson;

import com.jayway.jsonpath.JsonPath;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest(environments = "stacktrace")
public class FooStacktraceControllerTest {
    private final HttpClient httpClient;

    public FooStacktraceControllerTest(@Client("/") HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Test
    public void testFooController(){
        String response = httpClient.toBlocking().retrieve(HttpRequest.GET(""), Argument.STRING, Argument.STRING);
        assertEquals("random", JsonPath.parse(response).read("$.field", String.class));
        assertNotNull(JsonPath.parse(response).read("$.type"));
        assertEquals("Internal Server Error", JsonPath.parse(response).read("$.title", String.class));
        assertEquals(500, JsonPath.parse(response).read("$.status", Integer.class));
        assertNotNull(JsonPath.parse(response).read("$.localizedMessage"));
        assertNotNull(JsonPath.parse(response).read("$.message"));
        assertNotNull(JsonPath.parse(response).read("$.stackTrace"));
    }
}
