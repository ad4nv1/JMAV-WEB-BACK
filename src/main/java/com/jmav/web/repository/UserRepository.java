package com.jmav.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmav.web.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
