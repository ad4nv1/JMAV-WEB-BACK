package com.jmav.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmav.web.model.Seller;
@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

}
