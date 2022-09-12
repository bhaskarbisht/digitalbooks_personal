package com.books.service;

import java.util.List;
import java.util.Optional;

import com.books.model.Books;

public interface IBooksService {

	Integer saveBooks(Books book);

	public List<Books> getAllBooks();

	Optional<Books> getBookByBookID(Integer id);
	
	public List<Books> getBooksByAuthorId(Integer authorId);
	
	Books updateBook(Books book, Integer id);

	public void deleteBook(Integer id);
	
	public List<Books> searchBooks(String category,String authorName,Double price);
	
}
