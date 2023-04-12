package com.api.book.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="author_info")

public class Author {
	
	@Id
	private int authorId;
	private String authorName;
	private String authorLanguage;
	private String authorAddress;
	
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	
	


	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Author(String authorName, String authorLanguage, String authorAddress) {
		super();
		this.authorName = authorName;
		this.authorLanguage = authorLanguage;
		this.authorAddress = authorAddress;
	}



	public Author(int authorId, String authorName, String authorLanguage, String authorAddress) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorLanguage = authorLanguage;
		this.authorAddress = authorAddress;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorLanguage() {
		return authorLanguage;
	}
	public void setAuthorLanguage(String authorLanguage) {
		this.authorLanguage = authorLanguage;
	}
	public String getAuthorAddress() {
		return authorAddress;
	}
	public void setAuthorAddress(String authorAddress) {
		this.authorAddress = authorAddress;
	}
	
	
	
	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}

	


	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", authorLanguage=" + authorLanguage
				+ ", authorAddress=" + authorAddress + "]";
	}
	
	

}
