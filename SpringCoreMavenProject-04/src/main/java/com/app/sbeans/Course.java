package com.app.sbeans;

public class Course {
    private String courseName;
    private double fees;

    public Course(String courseName, double fees) {
        this.courseName = courseName;
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Course [courseName=" + courseName + ", fees=" + fees + "]";
    }
}