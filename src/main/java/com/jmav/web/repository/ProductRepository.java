package com.jmav.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmav.web.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
