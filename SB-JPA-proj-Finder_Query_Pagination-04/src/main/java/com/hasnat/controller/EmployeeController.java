package com.hasnat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hasnat.dto.EmployeeResponse;
import com.hasnat.service.EmployeeServiceImp;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeServiceImp empService;
	
	@GetMapping("employee")
	public EmployeeResponse getEmployee(@RequestParam Long id) {
		
		return empService.getEmployee(id);
	}

}
