package com.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Patient extends GenericIDType{
    private final String OHIP_Id;
    private final String firstName;
    private final String lastName;
    private final String age;
    private final String DOB;
    private final String gender;
    private final String address;
    private final String city;
    private final String phone;

    public Patient(@JsonProperty("id") Long id,
                   @JsonProperty("ohip_Id") String OHIP_Id,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("age") String age,
                   @JsonProperty("dob") String DOB,
                   @JsonProperty("gender") String gender,
                   @JsonProperty("address") String address,
                   @JsonProperty("city") String city,
                   @JsonProperty("phone") String phone) {
        this.id = id;
        this.OHIP_Id = OHIP_Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.DOB = DOB;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getOHIP_Id() {
        return OHIP_Id;
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

    public String getDOB() {
        return DOB;
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
