package com.hasnat.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle any RuntimeException
    @ExceptionHandler(UserNotFoundException.class)
    public String handleRuntimeException(UserNotFoundException ex, Model model) {
    	System.err.println(ex.getMessage());
        model.addAttribute("errorMessage", ex.getMessage());
        return "users";
    }


}
