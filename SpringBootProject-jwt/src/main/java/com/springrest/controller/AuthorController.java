package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.Author;
import com.springrest.repository.AuthorRepository;
import com.springrest.service.AuthorService;

@RestController
@CrossOrigin
public class AuthorController {
	

	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/addAuthor")
	public Author addAuthor(@RequestBody Author author) {
		return authorService.saveAuthor(author); 
	}
	
	
	@GetMapping("/getAuthor")
	public List<Author> getAuthor() {
		return authorService.fetchAuthor();	
	}
	
	@GetMapping("/getAuthor/{id}")
	public Author getAuthorById(@PathVariable String id){
		return authorService.getAuthorById(Integer.parseInt(id));
	}
	
	
	@GetMapping("/deleteAuthor/{id}")
	public String deleteAuthorById(@PathVariable String id) {
		
		return authorService.removeAuthorById(Integer.parseInt(id));
	}

}
