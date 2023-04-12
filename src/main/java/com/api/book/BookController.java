package com.api.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;

@RestController
public class BookController {
	
	@Autowired
	private com.api.book.entities.BookServices bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> GetBooks() {
		
		List<Book> list =this.bookService.getAllBook();
		
		
		
		if(list.size()<=0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> singlBook(@PathVariable("id") int id) {
			
		Book book =bookService.getBookById(id);
		
		if(book==null) {
			
			System.out.println(book);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		System.out.println(book);
		return ResponseEntity.status(HttpStatus.FOUND).body(book);
		
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		Book b= null;
		
		try {
			 
			b =this.bookService.addBook(book);
			
			 return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		
		}
		
		
		
		
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		
		
		this.bookService.deleteBook(id);
		
		
		
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book ,@PathVariable("id") int bookId) {
		
		
		this.bookService.updateBook(book,bookId);
		
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	
	

}