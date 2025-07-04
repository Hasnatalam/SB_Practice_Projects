package com.hasnat.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentServices {

	@Override
	public String healthCheck() {
		log.info("Health Check mathod called");
		return "Working";
	}


}
