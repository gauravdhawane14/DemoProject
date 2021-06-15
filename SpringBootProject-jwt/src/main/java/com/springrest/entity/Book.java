package com.springrest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String author;
	
//	@ManyToOne
//	@JoinColumn(name="author_id")
//	private Author author;
	
	
	

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

//	public Author getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(Author author) {
//		this.author = author;
//	}
	
	
	
}

