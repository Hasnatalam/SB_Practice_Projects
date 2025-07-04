package com.hasnat.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
	
	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Department is required")
	private String department;

	@NotBlank(message = "Email is required")
	private String email;

}
