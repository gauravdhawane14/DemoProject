package com.springrest.service;

import java.util.List;

import com.springrest.entity.Author;

public interface AuthorService {

	public Author saveAuthor(Author author);
	
	public List<Author> fetchAuthor();
	
	public Author getAuthorById(Integer id);
	
	public String removeAuthorById(Integer id);
}
