package com.hasnat.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Department02")
public class Department {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	private String title;
	private String hod;
	
	@OneToMany(mappedBy = "department")
	private List<Student> student;
}
