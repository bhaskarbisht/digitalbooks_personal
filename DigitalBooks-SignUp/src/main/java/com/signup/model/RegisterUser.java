package com.signup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class RegisterUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private Integer signUpAs;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	
	private String password;

	public Integer getSignUpAs() {
		return signUpAs;
	}

	public void setSignUpAs(Integer signUpAs) {
		this.signUpAs = signUpAs;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	public RegisterUser(Integer userId, Integer signUpAs, String firstName, String lastName, String email,
			String password) {
		super();
		this.userId = userId;
		this.signUpAs = signUpAs;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public RegisterUser() {
		super();
	}
	
	
	
	
}
