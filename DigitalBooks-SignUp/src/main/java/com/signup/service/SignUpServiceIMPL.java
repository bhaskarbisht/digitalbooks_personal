package com.signup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.model.RegisterUser;

@Service
public class SignUpServiceIMPL implements ISignUpService {

	@Autowired
	ISignupRepository signupRepository;

	@Override
	public Integer registerUser(RegisterUser user) {

		RegisterUser savedUser=signupRepository.save(user);
		return savedUser.getUserId();
	}

	@Override
	public Optional<RegisterUser> findUserByEmail(String email) {
		
		
		RegisterUser user=signupRepository.findByEmail(email);
		return Optional.ofNullable(user);
	}
	
}
