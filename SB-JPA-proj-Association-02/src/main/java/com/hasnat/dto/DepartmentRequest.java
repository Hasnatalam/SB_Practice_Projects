package com.hasnat.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentRequest {
	
	private String title;
	private String hod;
	

}
