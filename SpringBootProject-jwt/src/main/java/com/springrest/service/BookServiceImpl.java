package com.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springrest.entity.Book;
import com.springrest.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		bookRepository.save(book);
		return book;
	}

	@Override
	public List<Book> getAllBook() {

		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		return bookRepository.getById(id);
	}

	@Override
	public String removeBookById(Integer id) {
		//use repository
		Optional<Book> entity=bookRepository.findById(id);
		if(entity.isPresent()) {
			bookRepository.delete(entity.get());
			return "Book Deleted";
		}
		else {
			return "Book not found to Delete";  
		}
	}

	@Override
	public Book updateBookById(Integer id, Book book) {
		Book bookDetails=bookRepository.findById(id).get();
		   bookDetails.setName(book.getName());
		   bookDetails.setAuthor(book.getAuthor());
		   bookRepository.save(bookDetails);
		  return book;
	}
	
	@Override
	public List<Book> findBookByPagination(Integer pageNo, Integer pageSize) {
		
		Pageable pegeable=PageRequest.of(pageNo, pageSize);
		Page<Book> pageResult=bookRepository.findAll(pegeable);
		return pageResult.toList();
	}
}
