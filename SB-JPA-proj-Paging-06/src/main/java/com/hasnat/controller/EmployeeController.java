package com.hasnat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@GetMapping("/allemployees")
	public List<EmployeeResponse> getAllEmployees() {
		
		return empService.getAllEmployees();
	}
	
	

}
