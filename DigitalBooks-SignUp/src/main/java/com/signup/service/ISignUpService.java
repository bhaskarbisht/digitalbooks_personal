package com.signup.service;

import java.util.Optional;

import com.signup.model.RegisterUser;

public interface ISignUpService {

	public Integer registerUser(RegisterUser user);
	
	public Optional<RegisterUser> findUserByEmail(String email);
	
	
}
