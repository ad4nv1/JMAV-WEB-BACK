package com.jmav.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jmav.web.model.Product;
import com.jmav.web.repository.ProductRepository;



@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable long id) {
		return repository.findById(id)
		        .map(resp -> ResponseEntity.ok(resp))
		        .orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Product> Post(@Valid @RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Product> Put(@Valid @RequestBody Product product){
		return repository.findById(product.getId()).map(resp -> ResponseEntity.status(HttpStatus.OK).body(repository.save(product)))
		        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	} 
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<Product> product = repository.findById(id);
        if(product.isEmpty())
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repository.deleteById(id);
	}
	

}
