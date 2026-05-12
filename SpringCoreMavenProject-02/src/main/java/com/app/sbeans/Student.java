package com.app.sbeans;

public class Student {
    private String name;
    private String dept;
    private Address address;

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void display() {
        System.out.println("Student Name : " + name);
        System.out.println("Department   : " + dept);
        System.out.println("Address      : " + address);
    }
}