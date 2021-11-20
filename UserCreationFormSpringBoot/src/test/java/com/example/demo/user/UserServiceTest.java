package com.example.demo.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.User;
import com.example.demo.UserRepository;
import com.example.demo.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private UserRepository userRepository;
	
	private UserService underTest;
	
	@BeforeEach
	void setUp() {		
		underTest = new UserService(userRepository);
	}
	
	@Test
	void canGetAllUsers() {	
		// when
		underTest.getAllUsers();
		
		// then
		verify(userRepository).findAll();
	}
	
	@Test	
	void canAddUser() {
		//given
		String name = "Peter";
		String email = "peter@test.com";
		User user = new User(name, email);
		
		//when
		underTest.addNewUser(user);
		
		//then
		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
		
		//We use userArgumentCaptor.capture() to capture user in "userRepository.save(user);" under addNewUser in UserService.java
		verify(userRepository).save(userArgumentCaptor.capture());
		
		User capturedUser = userArgumentCaptor.getValue();
		
		assertThat(capturedUser).isEqualTo(user);
	}
}
