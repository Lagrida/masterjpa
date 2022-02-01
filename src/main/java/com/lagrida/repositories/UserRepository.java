package com.lagrida.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lagrida.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findById(long id);
	List<User> findAll();
}
