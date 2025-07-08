package com.hasnat.service;

import java.util.List;

import com.hasnat.dto.EmployeeResponse;

public interface EmployeeService {
	public EmployeeResponse getEmployee(Long id);
	public List<EmployeeResponse> getAllEmployees();
	
}
