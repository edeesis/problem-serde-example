package com.edeesis.micronaut.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.http.HttpStatus;
import io.micronaut.problem.HttpStatusType;
import org.zalando.problem.AbstractThrowableProblem;

public class CustomProblem extends AbstractThrowableProblem {
    @JsonProperty
    private final String field;


    public CustomProblem(String field) {
        super(null, HttpStatus.INTERNAL_SERVER_ERROR.getReason(), new HttpStatusType(HttpStatus.INTERNAL_SERVER_ERROR));
        this.field = field;
    }

    @JsonProperty
    public String getField() {
        return field;
    }
}