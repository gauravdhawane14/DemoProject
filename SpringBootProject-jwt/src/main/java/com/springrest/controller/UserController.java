package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	
	@PostMapping()
	public User add(@RequestParam("file") MultipartFile file, @RequestParam User user) {
		
		String path=filePathService.storeFile(file);
		
		

		
		ProfileImage imagePath=new ProfileImage();
		imagePath.setPath(path);
		
		String contentType=file.getContentType();
		imagePath.setContentType(contentType);
		
		user.setImage(imagePath);
		
		return userService.saveUser(user);
		
	}
	
	
	@GetMapping()
	public List<User> get(){
		return userService.fetchUser();
	}
	
	@GetMapping(path="/{id}")
	public User getById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	
	//delete 
	
	@DeleteMapping(path="/{id}")
	public String delete(@PathVariable Integer id) {
		
		User user=userService.getUserById(id);
		
		ProfileImage filePath=user.getImage();
		
		String file=filePath.getPath();
		
		filePathService.deleteFile(file);
		
		return userService.removeUserById(id);
	}

	@PutMapping(path="/{id}")
	public User editUserById(@PathVariable Integer id,@RequestParam("file") MultipartFile file,@RequestParam User user) {
		
        User user1=userService.getUserById(id);
		
		ProfileImage filePath=user1.getImage();
		
		String deleteFile=filePath.getPath();
		
		filePathService.deleteFile(deleteFile);
		
		String path=filePathService.storeFile(file);
	
		String contentType=file.getContentType();
		
		filePath.setPath(path);
		filePath.setContentType(contentType);
		
		user.setImage(filePath);
		
		return userService.updateUserById(id, user);
	}
	
	@GetMapping(path="/pagination")
	public Page<User> getPaginatedUser(@RequestParam String keyword,@RequestParam Integer pageNo,@RequestParam Integer pageSize){
		System.out.println("pagination");
		return userService.getPaginatedUser(keyword,pageNo,pageSize);
	}
	
	
	
}
