package com.books.service;

import java.util.List;
import java.util.Optional;

import com.books.model.Books;

public interface IBooksService {

	Integer saveBooks(Books book);

	public List<Books> getAllBooks();

	Optional<Books> getBookByBookID(Integer id);
	
	public List<Books> getBooksByAuthorId(Integer authorId);
	
	public List<Books> searchBooks(String category,String authorName,Double price);
}
