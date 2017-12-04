package com.johnwu.bookstorebackend.service;

import java.util.List;

import com.johnwu.bookstorebackend.domain.Book;

public interface BookService {
	List<Book> findAll();
	
	Book findOne(Long id);
	
	Book save(Book book);
	
	List<Book> blurrySearch(String title);
	
	void removeOne(Long id);
}
