package com.lagrida.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lagrida.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	Optional<Book> findById(long id);
	List<Book> findAll();
}
