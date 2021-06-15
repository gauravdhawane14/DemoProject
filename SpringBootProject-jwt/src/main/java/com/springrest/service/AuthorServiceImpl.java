package com.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.entity.Author;
import com.springrest.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public Author saveAuthor(Author author) {
		authorRepository.save(author);
		return author;
	}
	
	@Override
	public List<Author> fetchAuthor() {
		return authorRepository.findAll();
		
	}

	@Override
	public Author getAuthorById(Integer id) {
		return authorRepository.findById(id).get();
	}
	
	//delete Author
	@Override
	public String removeAuthorById(Integer id) {

		//use repository
		Optional<Author> entity=authorRepository.findById(id);
		  if(entity.isPresent()) {
			  authorRepository.delete(entity.get());
			  return "Author Deleted";
		  }
		  else {
			return "Author not found to Delete";  
		  }
	}
	

}
