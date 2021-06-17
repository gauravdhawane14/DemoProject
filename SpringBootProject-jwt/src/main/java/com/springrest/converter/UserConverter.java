package com.springrest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.model.User;

@Component
public class UserConverter implements Converter<String, User>  {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public User convert(String source) {
		
		User user=null;
		try {
			 user=objectMapper.readValue(source,User.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return user;
	}
}
