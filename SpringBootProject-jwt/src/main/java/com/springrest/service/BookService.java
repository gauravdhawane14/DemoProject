package com.springrest.service;

import java.util.List;

import com.springrest.entity.Book;

public interface BookService {
	
	public Book saveBook(Book book);

	public List<Book> getAllBook();

	public Book getBookById(Integer id);

	public String removeBookById(Integer id);

	public Book updateBookById(Integer id, Book book);
	
	public List<Book> findBookByPagination(Integer pageNo,Integer pageSize);

}
