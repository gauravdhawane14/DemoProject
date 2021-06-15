package com.springrest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String surname;
//	
//	@OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
//	@JoinColumn(name="author_id")
//	private List<Book> book;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

//	public List<Book> getBook() {
//		return book;
//	}
//
//	public void setBook(List<Book> book) {
//		this.book = book;
//	} 
	
	
	
}
