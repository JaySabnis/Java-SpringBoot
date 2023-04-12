package com.api.book.Dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.entities.Book;

public interface bookRepo extends CrudRepository<Book, Integer> {
	
	public Book findById(int id);
	

}
