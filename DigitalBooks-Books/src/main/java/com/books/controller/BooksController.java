package com.books.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.books.model.Books;
import com.books.service.IBooksService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins="http://localhost:4200/")

public class BooksController {
	
	private static String UPLOADED_FOLDER = System.getProperty("user.dir")+File.separator+"//src//main//resources";
	@Autowired
	IBooksService booksService;

	@PostMapping("/savebook")
	public Integer saveBook(@RequestParam("bookstring") String book,@RequestParam("image") MultipartFile file) throws JsonMappingException, JsonProcessingException {

		if (file.isEmpty()) {

		}

		try {
			// Get the file and save it somewhere
			System.out.println("seema "+UPLOADED_FOLDER);
			byte[] bytes = file.getBytes();
			Path path = Paths
					.get(UPLOADED_FOLDER + File.separator + "images" + File.separator + file.getOriginalFilename());
			Files.write(path, bytes);
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	Books bookobj=new ObjectMapper().readValue(book, Books.class);
	bookobj.setLogo(file.getOriginalFilename());
		return booksService.saveBooks(bookobj);
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
	

	@GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam("image") String image) throws IOException {
     //   File file = new File(SERVER_LOCATION + File.separator + image + EXTENSION);
        File file=new File(UPLOADED_FOLDER+ File.separator + "images" +File.separator + image);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
	
	
	

	
}
