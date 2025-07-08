package com.hasnat.service;

import java.util.List;
import java.util.Optional;

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
	public EmployeeResponse getEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			Employee emp = employee.get();
			EmployeeResponse employeeResponse = EmployeeResponse.builder()
					.id(emp.getId())
					.name(emp.getName())
					.role(emp.getRole())
					.email(emp.getEmail())
					.salary(emp.getSalary())
					.build();
			return employeeResponse;
		}
		return null;
	}

	@Override
	public List<EmployeeResponse> getAllEmployees() {
		return null;
	}
	
}
