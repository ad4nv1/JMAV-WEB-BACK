package com.jmav.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmav.web.model.User;
import com.jmav.web.repository.ProductRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Product {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct(){
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable long id) {
	        return null;
	}
	
	@PostMapping("/logar")
	public ResponseEntity<Product> Autentication(@Valid @RequestBody User user){
		return null;
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Product> Post(@Valid @RequestBody User usuario){
		 return null;
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Product> Put(@Valid @RequestBody User usuario){
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		
	}

}
