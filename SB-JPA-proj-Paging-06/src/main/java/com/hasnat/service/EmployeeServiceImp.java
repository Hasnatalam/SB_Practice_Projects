package com.hasnat.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hasnat.dto.EmployeeResponse;
import com.hasnat.entity.Employee;
import com.hasnat.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService{
	private final EmployeeRepository employeeRepository;
	

	@Override
	public List<EmployeeResponse> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		List<EmployeeResponse> employeeResponses = employees.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary())
				.build()).collect(Collectors.toList());
		
		return employeeResponses;
	}



	
}
