package com.app.sbeans;

public class Address {
    private String city;
    private int pinCode;

    public void setCity(String city) {
        this.city = city;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", pinCode=" + pinCode + "]";
    }
}