package com.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.signup.model.RegisterUser;
import com.signup.service.ISignUpService;

@RestController
public class SignupController {

	@Autowired
	ISignUpService signupService;
	
	@PostMapping("/signup")
	public Integer RegisterUser(@RequestBody RegisterUser user) {
		return signupService.registerUser(user);
	}
	
}
