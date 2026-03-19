package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserService {
	private Map<Long, User> userMap = new HashMap<>();
	private Long idCounter = 1L;
	
	//Get All User
	public List<User> getAllUsers(){
		return new ArrayList<>(userMap.values());
	}
	
	//Add User
	public User addUser(User user) {
		user.setId(idCounter++);
		userMap.put(user.getId(), user);
		return user;
	}
	
	//get user my Id
	public User getUserByid(Long id) {
		return userMap.get(id);
	}
	
	//Delete user by id
	public void deleteUser(Long id) {
		userMap.remove(id);
	}
	
	//Update User
	public User updateUser(Long id, User newUser) {
		User existinguser = userMap.get(id);
		
		if(existinguser != null) {
			existinguser.setName(newUser.getName());
			existinguser.setEmail(newUser.getEmail());
		}
		return existinguser;
	}
	
	
}







