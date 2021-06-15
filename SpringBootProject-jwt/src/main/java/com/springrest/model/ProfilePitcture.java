package com.springrest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ProfilePitcture {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Lob
	private byte[] picture;

	public ProfilePitcture(byte[] picture) {
		super();
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	
	
}
