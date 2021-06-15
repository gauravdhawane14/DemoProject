package com.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.entity.Book;
import com.springrest.model.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public List<User> fetchUser();

	public String removeUserById(Integer id);
	
	public User updateUserById(Integer id, User user);

	public User getUserById(Integer id);

	public Page<User> getPaginatedUser(String keyword,Integer pageNo, Integer pageSize);

   

}
