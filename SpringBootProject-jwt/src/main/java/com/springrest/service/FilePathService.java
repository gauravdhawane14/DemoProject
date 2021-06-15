package com.springrest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.repository.FilePathRepository;

@Service
public class FilePathService {

	@Autowired
	private FilePathRepository filePathRepository;

	Path fileStoragePath;


	public FilePathService(@Value("${file.upload-dir}") String fileStorageLocation) {
		fileStoragePath=Paths.get(fileStorageLocation).toAbsolutePath().normalize();

		try {

			Files.createDirectories(fileStoragePath);

		}catch (IOException e) {
			throw new RuntimeException("Issue in creating file directory");
		}

	}

	public String storeFile(MultipartFile file) {

		String fileName=StringUtils.cleanPath(file.getOriginalFilename());

		Path filePath=Paths.get(fileStoragePath+ "/" +fileName);

		System.out.println(filePath.toString()+" File Path");



		try {

			Files.copy(file.getInputStream(), filePath,StandardCopyOption.REPLACE_EXISTING);

		}catch(IOException e){
			throw new RuntimeException("Issue in Storing the file");
		}

		return filePath.toString();
	}


	public String deleteFile(String file) {
		
		Path filePath=Paths.get(file);
		

		try {

           Files.deleteIfExists(filePath);
			
		}catch(IOException e){
			throw new RuntimeException("File not found to delete");
		}
		
		return "File Deleted";



	}

}
