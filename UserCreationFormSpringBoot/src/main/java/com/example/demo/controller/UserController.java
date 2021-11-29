package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(path="/user") 
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {		
		this.userService = userService;
	}
		
	@GetMapping("/getAllUsers")
	public @ResponseBody List<User> getAllUsers() {		
		return userService.getAllUsers();
	}
	
	@GetMapping("/getUser/{userId}")
	public @ResponseBody User getUser(@PathVariable("userId") int userId) {		
		return userService.getUser(userId);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> registerNewUser(@RequestBody User user) {
		userService.addNewUser(user);
		return new ResponseEntity<String>("User Added", HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	}
	
	@PutMapping(path = "/updateUser/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable("userId") int userId,
			@RequestBody User user) {
		userService.updateUser(userId, user);
		return new ResponseEntity<String>("User Updated", HttpStatus.OK);
	}
}
