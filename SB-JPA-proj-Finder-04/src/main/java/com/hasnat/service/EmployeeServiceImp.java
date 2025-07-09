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

	@Override
	public List<EmployeeResponse> getAllEmployeesByRole(String role) {
		List<Employee> employee = employeeRepository.findAllByRole(role);
		return employee.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary()).build()).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeResponse> getAllEmployeesByNameAndRole(String name, String role) {
		List<Employee> employee = employeeRepository.findAllByNameAndRole(name, role);
		
		return employee.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary()).build()).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeResponse> getAllEmployeesByNameOrEmail(String name, String email) {
		
		List<Employee> employee = employeeRepository.findAllByNameOrEmail(name, email);
		
		return employee.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary()).build()).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeResponse> getAllEmployeesBySalaryBetween(Double minSalary, Double maxSalary) {
		List<Employee> employee = employeeRepository.findAllBySalaryBetween(minSalary, maxSalary);
		return employee.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary()).build()).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeResponse> getAllEmployeesBySalaryLessThan(Double salary) {
		List<Employee> employee = employeeRepository.findAllBySalaryLessThan(salary);
		return employee.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary()).build()).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeResponse> getAllEmployeesBySalaryGreaterThan(Double salary) {
		List<Employee> employee = employeeRepository.findAllBySalaryGreaterThan(salary);
		return employee.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary()).build()).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeResponse> getAllEmployeesByRoleIn(List<String> role) {
		List<Employee> employee = employeeRepository.findAllByRoleIn(role);
		return employee.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary()).build()).collect(Collectors.toList());
	}

	@Override
	public Long countByRole(String role) {
		return employeeRepository.countByRole(role);
	}

	@Override
	public Boolean existsByName(String name) {
		return employeeRepository.existsByName(name);
	}

	@Override
	public List<EmployeeResponse> findByNameIsNull() {
		List<Employee> employee = employeeRepository.findByNameIsNull();
		return employee.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary()).build()).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeResponse> findByNameIsNotNull() {
		List<Employee> employee = employeeRepository.findByNameIsNotNull();
		return employee.stream().map(emp-> EmployeeResponse.builder()
				.id(emp.getId())
				.name(emp.getName())
				.role(emp.getRole())
				.email(emp.getEmail())
				.salary(emp.getSalary()).build()).collect(Collectors.toList());
	}
	
	
}
