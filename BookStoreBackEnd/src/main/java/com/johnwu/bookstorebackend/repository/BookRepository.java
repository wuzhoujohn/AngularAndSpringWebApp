package com.johnwu.bookstorebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.johnwu.bookstorebackend.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	//spring boot will be smart enough to know this, it will look for 
	//the title that contains this keyword
	List<Book> findByTitleContaining(String keyword);
}
