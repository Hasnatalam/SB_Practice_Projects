package com.app.streamAPI.hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Employee> employees = Employee.getEmployees();
		
		// 1. Second highest salary employee
		Employee employee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
		System.out.println(employee);
		
		// 2. Highest paid employee in each department
		Map<String, Optional<Employee>> maxByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		maxByDept.forEach((k,v)-> System.err.println(k+" : "+v));
		
		// 3. Average salary of each department
		Map<String, Double> avgByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		avgByDept.forEach((k,v)-> System.out.println(k+" : "+v));
		
		// 4. Total salary Department
		Map<String, Double> expensesBydept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getSalary)));
		expensesBydept.forEach((k,v)-> System.err.println(k+" : "+v));
		
		// 5. No of employee in Department
		Map<String, Long> noOfEmp = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		noOfEmp.forEach((k,v)-> System.err.println(k+" : "+v));
		
		// 6. Youngest employee in department
		Map<String, Optional<Employee>> yngstBydept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparing(Employee::getAge))));
		yngstBydept.forEach((k,v)-> System.out.println(k+" : "+v));
		
		// 9 Employee names in department
		Map<String, String> empNameByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.joining(","))));
		empNameByDept.forEach((k,v)-> System.err.println(k+" : "+v));
		
		// nth salaried employee here n=6
		Employee employee2 = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(5).findFirst().get();
		System.out.println(employee2);
		
																									/*
		 =========================================================================================
						From second List
		 ========================================================================================= 
																									*/
		
		// Max Employee without optional
		Map<String, Employee> maxEmp = employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),Optional::get)));
		maxEmp.forEach((k,v)->System.out.println(k+" : "+v));
	

		// Second Max Employee without optional
		Map<String, Employee> secMaxEmp = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().get())));
		secMaxEmp.forEach((k,v)->System.err.println(k+" : "+v));
			

		// Second Max Employee without optional
		Map<String, Employee> unmfsecMaxEmp = employees.stream()
				.collect(Collectors.collectingAndThen( Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.toList(), 
								list->list.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().get())),
						Collections::unmodifiableMap
						));
		
		//unmfsecMaxEmp.remove("Finance");
		unmfsecMaxEmp.forEach((k,v)->System.out.println(k+" : "+v));
		
		//No of Employee in department as custom massage
		Map<String, String> countAsMsg = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.counting(),count-> "Total employee : "+count)));
		
		countAsMsg.forEach((k,v)->System.err.println(k+" : "+v));
		
		//Department have more then 2 employees
		List<String> dptName = employees.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()), map->map.entrySet().stream().filter(e-> e.getValue()>3).map(e->e.getKey()).collect(Collectors.toList())));
		dptName.forEach((d)->System.err.println(d));
	
		//Partioning employee salary < & > 60000 and 
		Map<Boolean, List<String>> collect = employees.stream().collect(Collectors.partitioningBy(e-> e.getSalary()>60000,Collectors.mapping(Employee::getName, Collectors.toList())));
		collect.forEach((k,v)->System.err.println(k+" : "+v));
		
		Map<Object, List<String>> collect2 = employees.stream().collect(Collectors.groupingBy(e-> e.getSalary()>60000?"Greater then 60000":"Less then 60000",Collectors.mapping(Employee::getName, Collectors.toList())));
		collect2.forEach((k,v)->System.out.println(k+" : "+v));


	}
}
