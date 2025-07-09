package com.hasnat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasnat.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public List<Employee> findAllByRole(String role);
	
	public List<Employee> findAllByNameAndRole(String name, String role);
	
	public List<Employee> findAllByNameOrEmail(String name, String email);
	
	public List<Employee> findAllBySalaryBetween(Double minSalary, Double maxSalary);
	
	public List<Employee> findAllBySalaryLessThan(Double salary);
	
	public List<Employee> findAllBySalaryGreaterThan(Double salary);
	
	public List<Employee> findAllByRoleIn(List<String> role);
	
	public Long countByRole(String role);
	
	public Boolean existsByName(String name);
	
	public List<Employee> findByNameIsNull();
	
	public List<Employee> findByNameIsNotNull();
	
	
	

}
