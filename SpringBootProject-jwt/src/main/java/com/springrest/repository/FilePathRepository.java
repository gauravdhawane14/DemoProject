package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.model.ProfileImage;



public interface FilePathRepository extends JpaRepository<ProfileImage, Integer> {

}
