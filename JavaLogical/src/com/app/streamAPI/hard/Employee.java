package com.app.streamAPI.hard;
import java.util.Arrays;
import java.util.List;

class Employee {

    private int id;
    private String name;
    private String department;
    private int age;
    private double salary;

    public Employee(int id, String name, String department, int age, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + department + " " + age + " " + salary;
    }

    public static List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee(1, "Amit", "IT", 25, 45000),
            new Employee(2, "Ravi", "IT", 30, 70000),
            new Employee(3, "Priya", "IT", 28, 60000),

            new Employee(4, "Sneha", "HR", 26, 40000),
            new Employee(5, "Kiran", "HR", 35, 65000),
            new Employee(6, "Anjali", "HR", 24, 38000),

            new Employee(7, "Rahul", "Finance", 32, 80000),
            new Employee(8, "Sweety", "Finance", 29, 75000),
            new Employee(9, "Vikram", "Finance", 41, 90000),

            new Employee(10, "Suresh", "Sales", 27, 50000),
            new Employee(11, "Meena", "Sales", 33, 72000),
            new Employee(12, "Arjun", "Sales", 23, 35000),

            new Employee(13, "Pooja", "Admin", 31, 55000),
            new Employee(14, "Manoj", "Admin", 45, 85000),
            new Employee(15, "Divya", "Admin", 22, 30000)
        );
    }
}