package com.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springrest.model.FileUploadResponse;
import com.springrest.service.FileStorageService;


@RestController
@RequestMapping(path = "file")
public class FileController {
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping(path = "/upload")
	public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile file){
		
		String fileName=fileStorageService.storeFile(file);
		
		//http://localhost:8080/download/abc.jpg
		String url=ServletUriComponentsBuilder.fromCurrentContextPath()
				        //.path("/download")
				        .path(fileName)
				        .toUriString();
		
		String contentType=file.getContentType();
		System.out.println(contentType+" ContentType");
		
		FileUploadResponse response=new FileUploadResponse(fileName, contentType ,url);
		
		
		return response;
		
	}
	
	
	

}
