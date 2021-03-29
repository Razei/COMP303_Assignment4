package com.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Centre extends GenericIDType{
    private final String centreName;
    private final String address;
    private final String city;
    private final String phone;
    private final String website;
    private final String email;

    public Centre(@JsonProperty("id") Long id,
                  @JsonProperty("centreName") String centreName,
                  @JsonProperty("address") String address,
                  @JsonProperty("city") String city,
                  @JsonProperty("phone") String phone,
                  @JsonProperty("website") String website,
                  @JsonProperty("email") String email) {
        this.id = id;
        this.centreName = centreName;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.website = website;
        this.email = email;
    }

    public String getCentreName() {
        return centreName;
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

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }
}
