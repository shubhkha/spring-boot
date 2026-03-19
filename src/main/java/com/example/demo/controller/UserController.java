package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	//Get all users
	@GetMapping
	public List<User>getUsers(){
		return service.getAllUsers();
	}
	
	//Post add user
	@PostMapping
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	//get User by id
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return service.getUserByid(id);
	}
	
	//DELETE user by id 
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return "User Deleted Succefully";
	}
	
	//Update User
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
	    return service.updateUser(id, user);
	}
}

















