package com.edeesis.micronaut.jackson;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class FooController {

    @Get
    public void get() {
        throw new CustomProblem("random");
    }
}