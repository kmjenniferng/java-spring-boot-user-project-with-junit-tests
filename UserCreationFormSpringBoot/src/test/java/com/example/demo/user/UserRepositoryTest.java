package com.example.demo.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository underTest;
	
	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}
	
	@Test
	void itShouldCheckWhenStudentEmailExists() {		
		// given
		String name = "Peter";
		String email = "peter@test.com";
		User user = new User(name, email);
		underTest.save(user); //we want to run it on in memory db - H2 database
				
		// when
		boolean expected = underTest.findUserByEmail(email);		
		
		// then
		assertThat(expected).isTrue();		
	}
	
	@Test
	void itShouldCheckWhenStudentEmailDoesNotExists() {		
		// given		
		String email = "peter@test.com";		
				
		// when
		boolean expected = underTest.findUserByEmail(email);		
		
		// then
		assertThat(expected).isFalse();		
	}
}