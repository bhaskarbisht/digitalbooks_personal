package com.books.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.model.Books;

@Service
public class BooksServiceImpl implements IBooksService {

	@Autowired
	IBooksRepository booksrepository;
	
	

	@Override
	public Integer saveBooks(Books book) {
		Books savedBook = booksrepository.save(book);
		return savedBook.getBookId();
	}

	@Override
	public List<Books> getAllBooks() {
		return booksrepository.findAll();
	}

	@Override
	public Optional<Books> getBookByBookID(Integer id) {

		return booksrepository.findById(id);
	}

	@Override
	public List<Books> getBooksByAuthorId(Integer authorId) {
		List<Books> books = booksrepository.findAll();
		return books.stream().filter(book -> book.getAuthorId().equals(authorId)).collect(Collectors.toList());

	}

	@Override
	public List<Books> searchBooks(String category, String authorName, Double price) {
		List<Books> books = booksrepository.findAll();
		return books.stream().filter(book -> book.getCategory().equalsIgnoreCase(category) && book.getAuthor().equalsIgnoreCase(authorName)
				&& book.getPrice().equals(price)).collect(Collectors.toList());

		
	}

}
