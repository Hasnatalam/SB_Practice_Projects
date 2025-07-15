//package com.hasnat.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hasnat.dto.EmployeeResponse;
//import com.hasnat.entity.Employee;
//import com.hasnat.service.EmployeeService;
//import com.hasnat.service.EmployeeServiceImp;
//
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/api/employees")
//@RequiredArgsConstructor
//public class EmployeeController implements EmployeeService{
//	
//	private final EmployeeServiceImp empService;
//
//	@PostMapping("/allemployees")
//	public List<EmployeeResponse> getAllEmployees(@RequestBody Employee employee) {
//		
//		return empService.getAllEmployees();
//	}
//	
//	
//
//}
