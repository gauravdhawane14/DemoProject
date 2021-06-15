package com.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springrest.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

//	@Query("select a.name,a.surname,b.name from Author a join a.book b")
//	public List<Author> getAuthor();
}
