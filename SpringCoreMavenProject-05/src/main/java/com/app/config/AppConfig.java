package com.app.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.app")
public class AppConfig {
@Bean
public LocalDateTime lt() {
	return LocalDateTime.now();
}
}
