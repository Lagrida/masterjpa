package com.lagrida.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lagrida.entities.Book;
import com.lagrida.entities.User;
import com.lagrida.repositories.BookRepository;
import com.lagrida.repositories.UserRepository;

@RestController
public class PrincipalController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/get_all_users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	@PostMapping("/add_user")
	@Transactional
	public User addUser(@RequestBody User user) {
		List<Book> books = user.getBooks();
		user.setBooks(Arrays.asList());
		User userSaved = userRepository.save(user);
		books.stream().forEach(book -> book.setUser(userSaved));
		//books = bookRepository.saveAll(books);
		userSaved.setBooks(books);
		return userRepository.save(userSaved);
	}
}
