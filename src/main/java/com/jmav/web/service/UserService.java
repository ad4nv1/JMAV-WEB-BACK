package com.jmav.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jmav.web.model.User;
import com.jmav.web.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public Optional<User> updateUser(User user) {
		if (repository.findById(user.getId()).isPresent()) {
			Optional<User> buscaUsuario = repository.findByEmail(user.getEmail());
			if (buscaUsuario.isPresent()) {				
				if (buscaUsuario.get().getId() != user.getId())
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
			}
			return Optional.of(repository.save(user));
		} 
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);		
	}	

}
