package com.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Books;
import com.books.service.IBooksService;

@RestController
public class BooksController {

	@Autowired
	IBooksService booksService;

	@PostMapping("/savebook")
	public Integer saveBook(@RequestBody Books book) {
		return booksService.saveBooks(book);
	}

	@GetMapping("/books")
	List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("book/{id}")
	public Optional<Books> getBook(@PathVariable("id") Integer bookid) {
		Optional<Books> authorbook = booksService.getBookByBookID(bookid);
		return authorbook;
	}
	
	@GetMapping("book/author/{authorId}")
	public List<Books> getBookByAuthor(@PathVariable("authorId") Integer authorId){
		return booksService.getBooksByAuthorId(authorId);
	}
	
	@GetMapping("/search")
	public List<Books> searchBooks(@RequestParam("category") String category,
			@RequestParam("authorName") String authorName,
			@RequestParam("price") Double price) {
		
		return booksService.searchBooks(category, authorName, price);
	
		
	}
	
}
