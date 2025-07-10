package com.hasnat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hasnat.dto.EmployeeResponse;
import com.hasnat.service.EmployeeService;
import com.hasnat.service.EmployeeServiceImp;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController implements EmployeeService{
	
	private final EmployeeServiceImp empService;
	@Override
	@GetMapping("/employee")
	public EmployeeResponse getEmployee(@RequestParam Long id) {
		
		return empService.getEmployee(id);
	}
	@Override
	@GetMapping("/allemployees")
	public List<EmployeeResponse> getAllEmployees() {
		
		return empService.getAllEmployees();
	}
	
	
	@Override
	@GetMapping("/role")
	public List<EmployeeResponse> getAllEmployeesByRole(@RequestParam String role) {
		return empService.getAllEmployeesByRole(role);
	}
	@Override
	@GetMapping("/employeesname")
	public List<String> getAllEmployeesName() {
		return empService.getAllEmployeesName();
	}

}
