package com.edeesis.micronaut.serde;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@MicronautTest
public class FooControllerTest {
    private final HttpClient httpClient;

    public FooControllerTest(@Client("/") HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Test
    public void testFooController() throws JSONException {
        String response = httpClient.toBlocking().retrieve(HttpRequest.GET(""), Argument.STRING, Argument.STRING);
        JSONAssert.assertEquals(response, """
                {"type":"about:blank","title":"Internal Server Error","status":500}""", true);
    }
}
