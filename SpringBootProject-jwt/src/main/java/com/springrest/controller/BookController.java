package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.Book;
import com.springrest.service.BookService;

@CrossOrigin
@RestController
@RequestMapping(path = "book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping()
	public Book add(@RequestBody Book book) {
		return bookService.saveBook(book) ;
	}
	
	@GetMapping()
	public List<Book> get() {
		return bookService.getAllBook();
	}
	
	@GetMapping(path="/{id}")
	public Book getById(@PathVariable String id) {
		return bookService.getBookById(Integer.parseInt(id));
	}
	

	@DeleteMapping(path="/{id}")
	public String deleteById(@PathVariable String id) {
		return bookService.removeBookById(Integer.parseInt(id));
	}

	@PutMapping(path="/{id}")
	public Book edit(@PathVariable Integer id,@RequestBody Book book) {
		return bookService.updateBookById(id, book);
	}
	
	@GetMapping(path = "/pagination")
	public List<Book> gatBookByPaginated(@RequestParam Integer pageNo,@RequestParam  Integer pageSize){
		System.out.println("pagination Method");
		return bookService.findBookByPagination(pageNo,pageSize);
	}
	
	
}
