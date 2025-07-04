package com.hasnat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hasnat.dto.StudentDto;
import com.hasnat.dto.StudentResponseDto;
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
	public StudentResponseDto saveStudent(@RequestBody StudentDto studentDto) {
		
		System.out.println(studentDto.getName());
		System.out.println(studentDto.getDepartment());
		System.out.println(studentDto.getEmail());
		return studentService.registerStudent(studentDto);
	}
	
	
																												
}
