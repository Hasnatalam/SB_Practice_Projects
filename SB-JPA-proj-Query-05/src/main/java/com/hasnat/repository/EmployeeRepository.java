package com.hasnat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hasnat.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = "Select * from employee01 where role = :role",nativeQuery = true)
	public List<Employee> getAllEmployeesByRole(@Param("role") String role);
	
	// In these two we can use anyone
	//@Query(value = "SELECT name FROM employee01 WHERE name IS NOT NULL",nativeQuery = true) //NQ
	@Query(value = "SELECT e.name FROM Employee e WHERE e.name Is NOT NULL ") // JPQL
	public List<String> getEmployeesName();
	
	

}
