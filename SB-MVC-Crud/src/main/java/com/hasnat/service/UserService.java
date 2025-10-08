package com.hasnat.service;

import java.util.List;

import com.hasnat.entity.User;

public interface  UserService {
	public User registerUser(User user);
	public List<User> getUsers();
	public User getUser(Integer id);
	public  User updateUser(User user);
	public String deleteUser(Integer id);
}
