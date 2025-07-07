package com.hasnat.services;

import org.springframework.stereotype.Service;

import com.hasnat.dto.AddressResponse;
import com.hasnat.dto.DepartmentResponse;
import com.hasnat.dto.StudentRequest;
import com.hasnat.dto.StudentResponse;
import com.hasnat.entity.Address;
import com.hasnat.entity.Department;
import com.hasnat.entity.Student;
import com.hasnat.repository.StudentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class StudentServiceImpl implements StudentServices {
    
    // These will be automatically injected by Lombok's @AllArgsConstructor
    private final StudentRepository studentRepository;
    
    
    @Override
    public String healthCheck() {
        log.info("Health Check method called");
        return "Working";
    }


	@Override
	public StudentResponse registerStudent(StudentRequest studentRequest) {
		Student student = Student.builder()
                .name(studentRequest.getName())
                .email(studentRequest.getEmail())
                .build();

        Address address = Address.builder()
                .city(studentRequest.getAddress().getCity())
                .country(studentRequest.getAddress().getCountry())
                .pinCode(studentRequest.getAddress().getPinCode())
                .student(student)  // Set the bidirectional relationship
                .build();
        
        Department department = Department.builder()
        		.title(studentRequest.getDepartment().getTitle())
        		.hod(studentRequest.getDepartment().getHod())
        		.build();

        student.setAddress(address);  // Set the address to student
        student.setDepartment(department);

        // Save only the Student (cascade will save Address)
        Student savedStudent = studentRepository.save(student);

        // Convert saved Entity back to DTO
        return StudentResponse.builder()
                .id(savedStudent.getId())
                .name(savedStudent.getName())
                .email(savedStudent.getEmail())
                .address(AddressResponse.builder()
                        .id(savedStudent.getAddress().getId())
                        .city(savedStudent.getAddress().getCity())
                        .country(savedStudent.getAddress().getCountry())
                        .pinCode(savedStudent.getAddress().getPinCode())
                        .build())
                .department(DepartmentResponse.builder()
                		.id(savedStudent.getDepartment().getId())
                		.title(savedStudent.getDepartment().getTitle())
                		.hod(savedStudent.getDepartment().getHod())
                		.build())
                .build();
    }
	 
	
	
}