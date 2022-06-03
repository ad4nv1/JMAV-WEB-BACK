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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jmav.web.model.Seller;
import com.jmav.web.repository.SellerRepository;

@RestController
@RequestMapping("/seller")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SellerController {
	
	@Autowired
	SellerRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Seller>> findAllSeller(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Seller> getById(@PathVariable long id) {
		return repository.findById(id)
		        .map(resp -> ResponseEntity.ok(resp))
		        .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Seller> Post(@Valid @RequestBody Seller seller){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(seller));
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<Seller> seller = repository.findById(id);
        if(seller.isEmpty())
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repository.deleteById(id);
	}

}
