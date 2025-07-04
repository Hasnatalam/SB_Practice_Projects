package com.hasnat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	
																												
}
