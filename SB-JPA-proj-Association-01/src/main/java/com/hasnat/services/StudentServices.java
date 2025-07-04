package com.hasnat.services;

import com.hasnat.dto.StudentDto;
import com.hasnat.dto.StudentResponseDto;

public interface StudentServices {
	public String healthCheck();
	public StudentResponseDto registerStudent(StudentDto studentDto);
}
