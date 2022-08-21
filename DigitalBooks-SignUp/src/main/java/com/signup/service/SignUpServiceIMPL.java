package com.signup.service;

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
	
}
