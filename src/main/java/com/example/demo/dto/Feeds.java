package com.example.demo.dto;

public class Feeds {
	
	private String userName;
	private String email;
	private String contact;
	public Feeds(String userName, String email, String contact) {
		super();
		this.userName = userName;
		this.email = email;
		this.contact = contact;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
