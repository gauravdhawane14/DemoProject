package com.springrest.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.model.ProfilePitcture;
import com.springrest.model.User;
import com.springrest.repository.ProfilePictureRepository;

@Service
public class DBFileService {
	
	private ProfilePictureRepository repository;

	
	public ProfilePitcture storeFile(MultipartFile file) {
		//normalize the file
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		
		
		
		try {
			
			// Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            ProfilePitcture dbFile=new ProfilePitcture(file.getBytes());
            
            return repository.save(dbFile);
			
		}catch(IOException e) {
			throw new RuntimeException("Could not store file");
		}
	}
	
	public ProfilePitcture getFile(Integer fileId) {
        return repository.findById(fileId).get();
      }
	
}

