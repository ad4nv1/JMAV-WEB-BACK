package com.jmav.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_usuario")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nameUsuario;
	
	@NotNull
	private String emailUsuario;
	
	@NotNull
	private String passwordUsuario;
	
	@NotNull
	private String statusUsuario;
	
	@NotNull
	private String developerUsuario;
	
	private String carUsuario;
	
	

	public User(long id, String name, String email, String password, String status, String developer) {
		this.id = id;
		this.nameUsuario = name;
		this.emailUsuario = email;
		this.passwordUsuario = password;
		this.statusUsuario = status;
		this.developerUsuario = developer;
	}
	public User() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameUsuario() {
		return nameUsuario;
	}
	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getPasswordUsuario() {
		return passwordUsuario;
	}
	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
	public String getStatusUsuario() {
		return statusUsuario;
	}
	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}
	public String getDeveloperUsuario() {
		return developerUsuario;
	}
	public void setDeveloperUsuario(String developerUsuario) {
		this.developerUsuario = developerUsuario;
	}
	public String getCarUsuario() {
		return carUsuario;
	}
	public void setCarUsuario(String carUsuario) {
		this.carUsuario = carUsuario;
	}

	

}
