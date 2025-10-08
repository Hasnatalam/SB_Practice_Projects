package com.hasnat.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hasnat.entity.User;
import com.hasnat.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute User user, ModelMap map) {
		userService.registerUser(user);	
		map.addAttribute("name",user.getName());
		
		return "index";
	}
	
	@GetMapping("/allUser")
	public String getAllUser(ModelMap map) {
		map.addAttribute("users", userService.getUsers());
		
		return "users";
	}
	
    @GetMapping("/updateUser/{id}")
    public String showFormForUpdate(@PathVariable Integer id, ModelMap model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "update-user";
    }
    
    
    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user,ModelMap map) {
    	userService.updateUser(user);
    	
    	map.addAttribute("users", userService.getUsers());
        return "users";
    }
    
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id, ModelMap map) {
    	userService.deleteUser(id);
    	
    	map.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/getUser")
    public String getUser(@RequestParam("id") Integer id, ModelMap map) {
    	User user = userService.getUser(id);
    	List<User> users = Arrays.asList(user);
    	System.err.println(users);
    	map.addAttribute("users", users);
    	System.err.println();
        return "users";
    }
    
}
