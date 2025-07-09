package com.hasnat.service;

import java.util.List;

import com.hasnat.dto.EmployeeResponse;
import com.hasnat.entity.Employee;

public interface EmployeeService {
	public EmployeeResponse getEmployee(Long id);
	public List<EmployeeResponse> getAllEmployees();
	
	
	public List<EmployeeResponse> getAllEmployeesByRole(String role);
	
	public List<EmployeeResponse> getAllEmployeesByNameAndRole(String name, String role);
	
	public List<EmployeeResponse> getAllEmployeesByNameOrEmail(String name, String email);
	
	public List<EmployeeResponse> getAllEmployeesBySalaryBetween(Double minSalary, Double maxSalary);
	
	public List<EmployeeResponse> getAllEmployeesBySalaryLessThan(Double salary);
	
	public List<EmployeeResponse> getAllEmployeesBySalaryGreaterThan(Double salary);
	
	public List<EmployeeResponse> getAllEmployeesByRoleIn(List<String> role);
	
	public Long countByRole(String role);
	
	public Boolean existsByName(String name);
	
	public List<EmployeeResponse> findByNameIsNull();
	
	public List<EmployeeResponse> findByNameIsNotNull();
	
}
