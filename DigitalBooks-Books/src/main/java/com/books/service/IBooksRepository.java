package com.books.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.model.Books;

public interface IBooksRepository extends JpaRepository<Books, Integer>{

	
}
