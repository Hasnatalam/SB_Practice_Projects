package com.hasnat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasnat.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
