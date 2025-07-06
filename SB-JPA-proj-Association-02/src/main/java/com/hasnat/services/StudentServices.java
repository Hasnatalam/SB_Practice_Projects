package com.hasnat.services;

import com.hasnat.dto.StudentRequest;
import com.hasnat.dto.StudentResponse;

public interface StudentServices {
	public String healthCheck();
	public StudentResponse registerStudent(StudentRequest studentRequest);
}
