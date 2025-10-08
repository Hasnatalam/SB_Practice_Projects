package com.hasnat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasnat.entity.User;
import com.hasnat.exception.UserNotFoundException;
import com.hasnat.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Integer id) {
		User user = userRepository.findById(id)
	               .orElseThrow(() -> new UserNotFoundException("User not found"));
		return user;
	}

	@Override
	public User updateUser(User user) {
	    return userRepository.findById(user.getId())
	            .map(existingUser -> {
	                existingUser.setName(user.getName());
	                existingUser.setEmail(user.getEmail());
	                existingUser.setPhone(user.getPhone());
	                // update other fields as needed
	                return userRepository.save(existingUser);
	            })
	            .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + user.getId()));
	}

	@Override
	public String deleteUser(Integer id) {
	    Optional<User> userOpt = userRepository.findById(id);

	    if (userOpt.isPresent()) {
	        String name = userOpt.get().getName(); // assuming getName() is your field
	        userRepository.deleteById(id);
	        return name;
	    } else {
	        return "User not found";
	    }
	}

	
	
	
	
}
