//package com.hasnat.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.hasnat.dto.EmployeeResponse;
//import com.hasnat.entity.Employee;
//import com.hasnat.repository.EmployeeRepository;
//
//import io.swagger.v3.oas.models.examples.Example;
//import lombok.AllArgsConstructor;
//@Service
//@AllArgsConstructor
//public class EmployeeServiceImp implements EmployeeService{
//	private final EmployeeRepository employeeRepository;
//	
//
//	public List<EmployeeResponse> getAllEmployees(Employee employee) {
//		
//		Example<Employee> example = 
//		
//		List<Employee> employees = employeeRepository.findAll(employee);
//		
//		List<EmployeeResponse> employeeResponses = employees.stream().map(emp-> EmployeeResponse.builder()
//				.id(emp.getId())
//				.name(emp.getName())
//				.role(emp.getRole())
//				.email(emp.getEmail())
//				.salary(emp.getSalary())
//				.build()).collect(Collectors.toList());
//		
//		return employeeResponses;
//	}
//
//
//
//	
//}
