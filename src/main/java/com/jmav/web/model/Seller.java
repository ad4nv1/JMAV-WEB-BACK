package com.jmav.web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Seller extends User{
	
	private double balance;
	
	@OneToMany(mappedBy = "seller", cascade =  CascadeType.ALL)
	@JsonIgnoreProperties("seller")
	private List<Product> productsSeller;

	public Seller() {}

	public Seller(long id, String name, String email, String password, String status, String developer, double balance) {
		super(id, name, email, password, status, developer);
		this.balance = balance;
	}
	
	public Seller(long id, String name, String email, String password, String status, String developer) {
		super(id, name, email, password, status, developer);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Product> getProductsSeller() {
		return productsSeller;
	}

	public void setProductsSeller(List<Product> productsSeller) {
		this.productsSeller = productsSeller;
	}

	
	

}
