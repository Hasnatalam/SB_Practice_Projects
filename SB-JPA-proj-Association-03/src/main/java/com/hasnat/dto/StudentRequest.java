package com.hasnat.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentRequest {
	
	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Email is required")
	private String email;
	
	private AddressRequest address;
	
	private DepartmentRequest department;
	

}
