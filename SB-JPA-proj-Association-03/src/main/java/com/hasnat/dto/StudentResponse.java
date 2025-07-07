package com.hasnat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
	private int id;
	private String name;
	private String email;
    private AddressResponse address;
    private DepartmentResponse department;
	
}
