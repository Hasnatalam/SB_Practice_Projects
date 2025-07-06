package com.hasnat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hasnat.dto.StudentRequest;
import com.hasnat.dto.StudentResponse;
import com.hasnat.services.StudentServiceImpl;



@RestController
@RequestMapping("/student/api")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentService;
	
	@GetMapping("/check")
	public String healthCheck() {
		return studentService.healthCheck();
	}
	
	@PostMapping("/register")
	public StudentResponse saveStudent(@RequestBody StudentRequest studentDto) {
		
		System.out.println(studentDto.getName());
		System.out.println(studentDto.getDepartment());
		System.out.println(studentDto.getEmail());
		return studentService.registerStudent(studentDto);
	}
	
	
																												
}
