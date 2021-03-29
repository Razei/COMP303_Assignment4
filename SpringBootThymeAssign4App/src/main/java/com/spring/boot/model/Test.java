package com.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test extends GenericIDType {
    private final String testDate;
    private final String symptoms;
    private final String status;

    public Test(@JsonProperty("id") Long id,
                @JsonProperty("testDate") String testDate,
                @JsonProperty("symptoms") String symptoms,
                @JsonProperty("status") String status) {
        this.id = id;
        this.testDate = testDate;
        this.symptoms = symptoms;
        this.status = status;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getStatus() {
        return status;
    }
}
