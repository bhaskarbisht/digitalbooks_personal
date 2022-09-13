package com.reader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ReaderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getData/{id}")
	public Object getData(@PathVariable("id")Integer bookid){
		Object records= restTemplate.getForObject("http://books-microservice/book/"+bookid,Object.class );

		return records;
	}
	
	@GetMapping("/getBooks")
	public Object getAllBooks(){
		Object records= restTemplate.getForObject("http://books-microservice/books/",Object.class );

		return records;
	}
	
	@GetMapping("/searchBook")
	public Object searchBooks(@RequestParam("category") String category,
			@RequestParam("authorName") String authorName,
			@RequestParam("price") Double price) {
		
		String url = "http://books-microservice/search?category={category}&authorName={authorName}&price={price}";
		
		Object records= restTemplate.getForObject(url,Object.class );	
		
				return records;
		
	}
	
	
	@GetMapping("/searchCategory/{cat}")
	public Object searchBooksBycategory(@PathVariable String cat) {
		
		String url = "http://books-microservice/category/";
		
		Object records= restTemplate.getForObject(url+cat,Object.class );	
		
				return records;
		
	}
	

	@GetMapping("/searchAuthor/{author}")
	public Object searchBooksByAuthor(@PathVariable String author) {
		
		String url = "http://books-microservice/author/";
		
		Object records= restTemplate.getForObject(url+author,Object.class );	
		
				return records;
		
	}
	

	@GetMapping("/searchPrice/{price}")
	public Object searchBooksByPrice(@PathVariable Double price) {
		
		String url = "http://books-microservice/price/";
		
		Object records= restTemplate.getForObject(url+price,Object.class );	
		
				return records;
		
	}
	

}
