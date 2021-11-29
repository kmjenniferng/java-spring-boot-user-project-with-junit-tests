package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {		
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUser(int userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));
	}
	
	public void addNewUser(User user) {		
		boolean existsEmail = userRepository.findUserByEmail(user.getEmail());
		if (existsEmail) {
			throw new IllegalStateException("Unable to add user because of email taken: " + user.getEmail());
		}		
		userRepository.save(user);
	}
	
	public void deleteUser(int userId) {		
		boolean exists = userRepository.existsById(userId);
		if (!exists) {
			throw new IllegalStateException("User with id " + userId + " does not exist");
		}
		userRepository.deleteById(userId);
	}
	
	public void updateUser(int userId, User user) {
		User userInDB = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));
		
		String nameInput = user.getName();
		if (nameInput != null && nameInput.length() > 0) userInDB.setName(nameInput);	
		
		String emailInput = user.getEmail();
		boolean existsEmail = userRepository.findUserByEmail(emailInput);
		if (existsEmail) {
			throw new IllegalStateException("Unable to update user email because email is taken: " + emailInput);
		}
		if (emailInput != null && emailInput.length() > 0) userInDB.setEmail(emailInput);
		userRepository.save(userInDB);
	}
}