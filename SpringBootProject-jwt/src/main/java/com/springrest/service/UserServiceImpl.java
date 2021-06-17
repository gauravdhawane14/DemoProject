package com.springrest.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.entity.Book;
import com.springrest.model.User;
import com.springrest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public User saveUser(User user){
		
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> fetchUser() {
		return	userRepository.findAll();	
	}

	@Override
	public String removeUserById(Integer id) {
		//use repository
		Optional<User> entity=userRepository.findById(id);
		if(entity.isPresent()) {
			userRepository.delete(entity.get());
			return "User Deleted";
		}
		else {
			return "User not found to Delete";  
		}
	}
	
	@Override
	public User updateUserById(Integer id, User user) {
		User userDetails=userRepository.findById(id).get();
		
		   userDetails.setImage(user.getImage());
		   userDetails.setUsername(user.getUsername());
		   userDetails.setPassword(user.getPassword());
		   userDetails.setFirstName(user.getFirstName());
		   userDetails.setLastName(user.getLastName());
		   userDetails.setEmail(user.getEmail());
		   userDetails.setPhoneNo(user.getPhoneNo());
		   
		   
		   userRepository.save(userDetails);
		   
		  return user;
	}

	
	@Override
	public User getUserById(Integer id) {
		
		return userRepository.getById(id);
	}

	@Override
	public Page<User> getPaginatedUser(String keyword,Integer pageNo, Integer pageSize) {
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		Page<User> pageResult;
		if(keyword !=null) {
		   pageResult=userRepository.findByUserName(keyword,pageable);
		}
		else {
			pageResult=userRepository.findAll(pageable);
		}
		return pageResult;
	}



}
