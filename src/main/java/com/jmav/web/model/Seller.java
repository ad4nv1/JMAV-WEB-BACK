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
	private List<Product> products;

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
