package com.hasnat.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
@Data
@Entity
@Table(name="Students01")
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(nullable = false,length = 30)
	private String name;
	@Column(nullable = false, length = 30)
	private String department;
	@Column(nullable = false, length = 50,unique = true)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
	private Address address;
	

}
