package com.hasnat.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {  // Corrected method name
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}