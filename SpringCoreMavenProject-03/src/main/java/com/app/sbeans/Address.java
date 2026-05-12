package com.app.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

    @Value("Hyderabad")
    private String city;

    @Value("500038")
    private int pinCode;

    @Override
    public String toString() {
        return "Address [city=" + city + ", pinCode=" + pinCode + "]";
    }
}