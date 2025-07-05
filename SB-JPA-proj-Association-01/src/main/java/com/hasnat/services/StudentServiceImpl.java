package com.hasnat.services;

import org.springframework.stereotype.Service;

import com.hasnat.dto.AddressResponse;
import com.hasnat.dto.StudentRequest;
import com.hasnat.dto.StudentResponse;
import com.hasnat.entity.Address;
import com.hasnat.entity.Student;
import com.hasnat.repository.StudentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class StudentServiceImpl implements StudentServices {
    
    // These will be automatically injected by Lombok's @RequiredArgsConstructor
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
                .department(studentRequest.getDepartment())
                .email(studentRequest.getEmail())
                .build();

        Address address = Address.builder()
                .city(studentRequest.getAddress().getCity())
                .country(studentRequest.getAddress().getCountry())
                .pinCode(studentRequest.getAddress().getPinCode())
                .student(student)  // Set the bidirectional relationship
                .build();

        student.setAddress(address);  // Set the address to student

        // Save only the Student (cascade will save Address)
        Student savedStudent = studentRepository.save(student);

        // Convert saved Entity back to DTO
        return StudentResponse.builder()
                .id(savedStudent.getId())
                .name(savedStudent.getName())
                .department(savedStudent.getDepartment())
                .email(savedStudent.getEmail())
                .address(AddressResponse.builder()
                        .id(savedStudent.getAddress().getId())
                        .city(savedStudent.getAddress().getCity())
                        .country(savedStudent.getAddress().getCountry())
                        .pinCode(savedStudent.getAddress().getPinCode())
                        .build())
                .build();
    }
	

//	@Override
//	public StudentResponse registerStudent(StudentRequest studentDto) {
//		
//		Student student= Student.builder()
//				.name(studentDto.getName())
//				.department(studentDto.getDepartment())
//				.email(studentDto.getEmail()).build();
//		
//		Student savedStudent = studentRepository.save(student);
//		
//		StudentResponse studentResponseDto = StudentResponse.builder()
//				.id(savedStudent.getId())
//				.name(savedStudent.getName())
//				.department(savedStudent.getDepartment())
//				.email(savedStudent.getEmail())
//				.build();
//		return studentResponseDto;
//		
//	}

//	private final ModelMapper modelMapper;
//    @Override
//    public StudentResponseDto registerStudent(StudentDto studentDto) {
//        log.info("Request for save student");
//        
//        // Convert DTO to Entity using ModelMapper
//        Student student = modelMapper.map(studentDto, Student.class);
//        
//        // Save to database
//        System.out.println(student);
//        Student savedStudent = studentRepository.save(student);
//
//        log.info("Student saved");
//        
//        // Convert back to Response DTO
//        return modelMapper.map(savedStudent, StudentResponseDto.class);
//    }
    
    
       
	
	
}