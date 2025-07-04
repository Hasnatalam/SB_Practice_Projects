package com.hasnat.services;

import org.springframework.stereotype.Service;

import com.hasnat.dto.StudentDto;
import com.hasnat.dto.StudentResponseDto;
import com.hasnat.entity.Student;
import com.hasnat.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServices {
    
    // These will be automatically injected by Lombok's @RequiredArgsConstructor
    private final StudentRepository studentRepository;
    
    
    @Override
    public String healthCheck() {
        log.info("Health Check method called");
        return "Working";
    }

	@Override
	public StudentResponseDto registerStudent(StudentDto studentDto) {
		
		Student student= Student.builder()
				.name(studentDto.getName())
				.department(studentDto.getDepartment())
				.email(studentDto.getEmail()).build();
		
		Student savedStudent = studentRepository.save(student);
		
		StudentResponseDto studentResponseDto = StudentResponseDto.builder()
				.id(savedStudent.getId())
				.name(savedStudent.getName())
				.department(savedStudent.getDepartment())
				.email(savedStudent.getEmail())
				.build();
		return studentResponseDto;
		
	}

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