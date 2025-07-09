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
	@GetMapping("/nameandrole")
	public List<EmployeeResponse> getAllEmployeesByNameAndRole(@RequestParam String name, String role) {
		return empService.getAllEmployeesByNameAndRole(name, role);
	}
	@Override
	@GetMapping("/nameoremail")
	public List<EmployeeResponse> getAllEmployeesByNameOrEmail(@RequestParam String name, String email) {
		return empService.getAllEmployeesByNameOrEmail(name, email);
	}
	@Override
	@GetMapping("/salaryrange")
	public List<EmployeeResponse> getAllEmployeesBySalaryBetween(@RequestParam Double minSalary, Double maxSalary) {
		return empService.getAllEmployeesBySalaryBetween(minSalary, maxSalary);
	}
	@Override
	@GetMapping("/maxalary")
	public List<EmployeeResponse> getAllEmployeesBySalaryLessThan(@RequestParam Double salary) {
		return empService.getAllEmployeesBySalaryLessThan(salary);
	}
	@Override
	@GetMapping("/minsalary")
	public List<EmployeeResponse> getAllEmployeesBySalaryGreaterThan(@RequestParam Double salary) {
		return empService.getAllEmployeesBySalaryGreaterThan(salary);
	}
	@Override
	@GetMapping("/rolein")
	public List<EmployeeResponse> getAllEmployeesByRoleIn(@RequestParam List<String> role) {
		return empService.getAllEmployeesByRoleIn(role);
	}
	@Override
	@GetMapping("/count")
	public Long countByRole(@RequestParam String role) {
		return empService.countByRole(role);
	}
	@Override
	@GetMapping("/isexist")
	public Boolean existsByName(@RequestParam String name) {
		return empService.existsByName(name);
	}
	@Override
	@GetMapping("/isnamenull")
	public List<EmployeeResponse> findByNameIsNull() {
		return empService.findByNameIsNull();
	}
	@Override
	@GetMapping("/isnamenotnull")
	public List<EmployeeResponse> findByNameIsNotNull() {
		return empService.findByNameIsNotNull();
	}
}
