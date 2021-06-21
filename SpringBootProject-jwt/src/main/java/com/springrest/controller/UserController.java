package com.springrest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.model.ProfileImage;
import com.springrest.model.User;
import com.springrest.service.FilePathService;
import com.springrest.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(path = "user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private FilePathService filePathService;

	@Autowired
	private ValidationHandler validation;

	@PostMapping()
	public ResponseEntity<Object> add(@RequestParam("file") MultipartFile file,@RequestParam User user) {

		ResponseEntity<Object> entity=null;

		if(user.getUsername()!=null) {
			String path=filePathService.storeFile(file);

			ProfileImage imagePath=new ProfileImage();
			imagePath.setPath(path);

			String contentType=file.getContentType();
			imagePath.setContentType(contentType);

			user.setImage(imagePath);

			User saveUser=userService.saveUser(user);

			entity=new ResponseEntity<Object>(saveUser,HttpStatus.CREATED);
		}
		else {
			entity=validation.handleException("username is required");
		}

		return entity;
	}

	@GetMapping()
	public List<User> get(){
		return userService.fetchUser();
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Object> getById(@PathVariable Integer id) {

		User user=userService.getUserById(id);
		ResponseEntity<Object> entity=validation.handleException("user not found");

		return entity;
	}

	@DeleteMapping(path="/{id}")
	public String delete(@PathVariable Integer id) {
		try {
			User user=userService.getUserById(id);

			ProfileImage filePath=user.getImage();

			String file=filePath.getPath();

			filePathService.deleteFile(file);

			return userService.removeUserById(id);
		}
		catch(Exception e) {
			return "User not found to delete";
		}
	}

	@PutMapping(path="/{id}")
	public ResponseEntity<Object> editUserById(@PathVariable Integer id,@RequestParam("file") MultipartFile file,@RequestParam User user) {

		ResponseEntity<Object> entity=null;

		User userRefId=null;
		try {
			userRefId = userService.findUserById(id).get();
		} catch (Exception e) {

			if(userRefId!=null) {

				ProfileImage filePath=userRefId.getImage();

				String deleteFile=filePath.getPath();

				filePathService.deleteFile(deleteFile);

				String path=filePathService.storeFile(file);

				String contentType=file.getContentType();

				filePath.setPath(path);
				filePath.setContentType(contentType);

				user.setImage(filePath);

				User saveUser=userService.updateUserById(id, user);

				entity=new ResponseEntity<Object>(saveUser,HttpStatus.OK);
			}
			else {
				entity=validation.handleException("user not found to update");
			}
		}

		return entity;
	}

	@GetMapping(path="/pagination")
	public Page<User> getPaginatedUser(@RequestParam String keyword,@RequestParam Integer pageNo,@RequestParam Integer pageSize){
		System.out.println("pagination");
		return userService.getPaginatedUser(keyword,pageNo,pageSize);
	}



}
