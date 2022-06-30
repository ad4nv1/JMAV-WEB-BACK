package com.jmav.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jmav.web.model.Seller;
import com.jmav.web.model.User;
import com.jmav.web.repository.SellerRepository;
import com.jmav.web.repository.UserRepository;

@Service
public class SellerService {
	
	@Autowired
	SellerRepository repository;
	
	@Autowired
	UserRepository repositoryUser;

	public Optional<Seller> updateUser(Seller seller) {
		if (repository.findById(seller.getId()).isPresent()) {
			Optional<Seller> buscaSeller = repository.findByEmailUsuario(seller.getEmailUsuario());
			Optional<User> buscaUser = repositoryUser.findByEmailUsuario(seller.getEmailUsuario());
			if (buscaSeller.isPresent() || buscaUser.isPresent()) {				
				if (buscaSeller.get().getId() != seller.getId() )
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vendedor já existe!", null);
			}
			return Optional.of(repository.save(seller));
		} 
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor não encontrado!", null);		
	}
}
