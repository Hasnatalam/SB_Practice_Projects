package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.sbeans.Address;
import com.app.sbeans.Course;
import com.app.sbeans.Student;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("Hyderabad", 500038);
    }

    @Bean
    public Course course() {
        return new Course("Java Full Stack", 45000);
    }

    @Bean
    public Student student() {
        return new Student("Hasnat", "MCA", address(), course());
    }
}