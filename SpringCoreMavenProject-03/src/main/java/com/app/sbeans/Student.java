package com.app.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("Hasnat")
    private String name;

    @Value("MCA")
    private String dept;

    @Autowired
    private Address address;

    public void display() {
        System.out.println("Student Name : " + name);
        System.out.println("Department   : " + dept);
        System.out.println("Address      : " + address);
    }
}