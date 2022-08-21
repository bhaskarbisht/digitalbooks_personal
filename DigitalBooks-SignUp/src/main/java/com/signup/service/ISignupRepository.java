package com.signup.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signup.model.RegisterUser;

public interface ISignupRepository extends JpaRepository<RegisterUser, Integer>{

}
