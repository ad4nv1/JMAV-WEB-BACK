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

import com.jmav.web.model.User;
import com.jmav.web.model.dto.LogarDto;
import com.jmav.web.repository.UserRepository;
import com.jmav.web.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserService service;
	
	@GetMapping("/all")
	public ResponseEntity findAllUser(){
		try {
			return ResponseEntity.ok(repository.findAll());
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable long id) {
	        return repository.findById(id)
		        .map(resp -> ResponseEntity.ok(resp))
		        .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/logar")
	public ResponseEntity Autentication(@Valid @RequestBody LogarDto user){
		try {
			if(repository.findByEmail(user.getEmail()).isPresent()) {
				Optional<User> userLogin = repository.findByEmail(user.getEmail());
				if(user.getPassword().equals(userLogin.get().getPassword()))
					return ResponseEntity.status(HttpStatus.OK).body(userLogin);
				else return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Login ou senha incorretos");
			}else return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuario não encontrado");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity Post(@Valid @RequestBody User usuario){
		if(repository.findByEmail(usuario.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}else {
			try {
				return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.OK).body(e);
			}
			
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<User> Put(@Valid @RequestBody User user){
		return service.updateUser(user)
                .map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<User> user = repository.findById(id);
        if(user.isEmpty())
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repository.deleteById(id);
	}
	
	@PostMapping("/updatecar")
	public ResponseEntity updateCar(@RequestBody Long id, String valor) {
		if(repository.findById(id).isPresent()) {
			User user = repository.getById(id);
			user.setCar(valor);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuário não encontrado");
		}
		
	}
	
}
