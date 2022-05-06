package com.jmav.web.model.dto;

public class LogarDto {
	
	private String email,password;
	
	

	public LogarDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public LogarDto() {}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
