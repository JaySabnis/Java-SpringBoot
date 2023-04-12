package com.api.book.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.Dao.bookRepo;

@Component
public class BookServices {

@Autowired
private bookRepo bookrepo;


public List<Book> getAllBook(){
	
	 List<Book> list= new ArrayList<>();
	 
	try {
		
			list = (List<Book>) this.bookrepo.findAll();
	 
	}catch (Exception e) {
		
		e.printStackTrace();
		
	} 
	 
	return list;
	
	}


public Book getBookById(int BookId) {
	
	
	Book book = null;
	try {
		
		book = this.bookrepo.findById(BookId);
	
	
	}catch(Exception e) {
		e.printStackTrace();
		
	}
	return book;
	
}

public Book addBook(Book b) {
	
	this.bookrepo.save(b);
	return b;
	
} 


public void deleteBook(int id) {
	
	this.bookrepo.deleteById(id);	
	
	
}


public void updateBook(Book book, int bookId) {
	
		
	book.setId(bookId);
	this.bookrepo.save(book);
	
	
}



}
