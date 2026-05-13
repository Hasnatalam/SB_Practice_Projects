package com.app.service;

import java.util.List;

import com.app.entity.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee emp);
	public Employee getEmployee(Integer id);
	public List<Employee> getllEmployee();
	public String deleteEmployee(Integer id);
	public Employee updateEmployee(Employee emp);
}
