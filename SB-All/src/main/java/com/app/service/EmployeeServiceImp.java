package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Override
//    public Employee saveEmployee(Employee emp) {
//        return employeeRepository.save(emp);
//    }
    @Override
    public Employee saveEmployee(Employee emp) {

        if (emp.getAddress() != null) {
            emp.getAddress().forEach(address -> {
                address.setEmployee(emp);
            });
        }

        return employeeRepository.save(emp);
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public String deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully";
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }
}