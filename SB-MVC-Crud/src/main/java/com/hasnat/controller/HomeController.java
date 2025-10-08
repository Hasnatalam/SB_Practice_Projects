package com.hasnat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // matches register.html in templates folder
    }
    
    
}
