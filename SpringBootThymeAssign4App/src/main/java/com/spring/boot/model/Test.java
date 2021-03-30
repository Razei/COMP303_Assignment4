package com.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    private Integer testId;
    private final String testDate;
    private final String symptoms;
    private final String status;
    private final Integer patient_id;

    public Test(@JsonProperty("testId") Integer testId,
                @JsonProperty("testDate") String testDate,
                @JsonProperty("symptoms") String symptoms,
                @JsonProperty("status") String status,
                @JsonProperty("patient_id") int patient_id) {
        this.testId = testId;
        this.testDate = testDate;
        this.symptoms = symptoms;
        this.status = status;
        this.patient_id = patient_id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setId(Integer testId) {
        this.testId = testId;
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

    public int getPatient_id() {
        return patient_id;
    }


}
