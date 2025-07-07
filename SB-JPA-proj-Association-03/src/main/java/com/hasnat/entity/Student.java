package com.hasnat.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
@Data
@Entity
@Table(name="Students03")
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(nullable = false,length = 30)
	private String name;
	@Column(nullable = false, length = 50,unique = true)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	private Department department;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "student_course03",
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "course_id")
	    )
	private List<Courses> courses; 
	
	
	

}
