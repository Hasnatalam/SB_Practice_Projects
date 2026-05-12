package com.app.sbeans;

public class Student {
    private String name;
    private String dept;
    private Address address;
    private Course course;

    public Student(String name, String dept, Address address, Course course) {
        this.name = name;
        this.dept = dept;
        this.address = address;
        this.course = course;
    }

    public void display() {
        System.out.println("Student Name : " + name);
        System.out.println("Department   : " + dept);
        System.out.println("Address      : " + address);
        System.out.println("Course       : " + course);
    }
}