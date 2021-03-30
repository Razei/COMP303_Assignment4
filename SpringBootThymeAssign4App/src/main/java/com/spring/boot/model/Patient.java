package com.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Patient{
    private final Integer patientId;
    private final String ohip_ID;
    private final String firstName;
    private final String lastName;
    private final String age;
    private final String gender;
    private final String address;
    private final String city;
    private final String phone;

    public Patient(@JsonProperty("patientId") Integer patientId,
                   @JsonProperty("ohip_ID") String ohip_ID,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("age") String age,
                   @JsonProperty("gender") String gender,
                   @JsonProperty("address") String address,
                   @JsonProperty("city") String city,
                   @JsonProperty("phone") String phone) {
        this.patientId = patientId;
        this.ohip_ID = ohip_ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getOhip_ID() {
        return ohip_ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }
}
