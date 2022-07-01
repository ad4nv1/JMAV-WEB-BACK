package com.jmav.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_produto")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private double price;
	
	@NotNull
	private String description;
	
	private String image;
	
	@NotNull
	private String provider;
	
	private String category;
	
	@NotNull
	private int inventory;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("productsSeller")
	private User seller;
	
	
	
	public Product(long id, @NotNull String name, @NotNull double price, @NotNull String description, String image,
			@NotNull String provider, String category, @NotNull int inventory, User seller) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.provider = provider;
		this.category = category;
		this.inventory = inventory;
		this.seller = seller;
	}
	public Product() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

}
