package com.signup.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.signup.model.RegisterUser;
import com.signup.service.ISignUpService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SignupController {

	@Autowired
	ISignUpService signupService;

	@PostMapping("/signup")
	public Integer RegisterUser(@RequestBody RegisterUser user) {
		return signupService.registerUser(user);
	}

	@PostMapping("/login")
	public RegisterUser LoginUser(@RequestBody RegisterUser userdata) {

		Optional<RegisterUser> user = signupService.findUserByEmail(userdata.getEmail());
		if (user.isPresent()) {
			RegisterUser rs = user.get();
			if (rs.getPassword().equals(userdata.getPassword())) {
				return rs;
			}
			
		}
		return null;
			

	}

}
