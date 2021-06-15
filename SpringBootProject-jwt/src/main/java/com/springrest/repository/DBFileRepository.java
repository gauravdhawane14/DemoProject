package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.model.User;

public interface DBFileRepository extends JpaRepository<User, Integer> {

}
