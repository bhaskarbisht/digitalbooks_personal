package com.signup.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.signup.model.RegisterUser;

public interface ISignupRepository extends JpaRepository<RegisterUser, Integer>{

	@Query("SELECT u fROM RegisterUser u where u.email=?1")
	RegisterUser findByEmail(String email);
}
