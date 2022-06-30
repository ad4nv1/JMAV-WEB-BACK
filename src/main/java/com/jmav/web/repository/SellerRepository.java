package com.jmav.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmav.web.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{
	public Optional<Seller> findByEmailUsuario(String email);
}
