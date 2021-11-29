package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="user")
@Entity
public class User {
	
	@Id
	@SequenceGenerator (
			name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
	)
	
	@GeneratedValue (
            generator = "user_sequence",
            strategy = GenerationType.SEQUENCE
    )
	private int id;
	private String name;
	private String email;
	
	public User() {
		
	}
	
	public User(String name, String email) {		
		this.name = name;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
