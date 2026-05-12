package com.app.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MyArrayList {
	public static void main(String[] args) {
		
		List<Employee> employee = getEmployee();
		
		//employee.forEach(emp->System.out.println(emp));
		
		employee.sort((a,b)->a.getName().compareTo(b.getName()));
		
		employee.forEach(s-> System.out.println(s));
		
		
		Set<Employee> set = new HashSet<>();
		
		set.addAll(employee);
		set.forEach(s->System.out.println(s+".........."));
		
		SortedSet<Employee> sSet = new TreeSet<>(Comparator.comparing(Employee::getSalary));
		sSet.addAll(employee);
		
		sSet.forEach(System.err::println);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static List<Employee> getEmployee(){
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1,"Roni",10000));
		empList.add(new Employee(4,"Sumit",10800));
		empList.add(new Employee(2,"Scott",15000));
		empList.add(new Employee(3,"Alex",10400));
		empList.add(new Employee(5,"Rahman",10000));
		empList.add(new Employee(7,"Amit",10000));
		empList.add(new Employee(6,"Max",10000));
		return empList;
	}
}
class Employee{
	private float id ;
	private String name;
	private int salary;
	
	public Employee(int id, String name, int salary) {
		this.id=id;
		this.name=name;
		this.salary= salary;
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public float getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}