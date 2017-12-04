package com.johnwu.bookstorebackend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.johnwu.bookstorebackend.domain.Book;
import com.johnwu.bookstorebackend.service.BookService;

@RestController
@RequestMapping("/book")
public class BookResource {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Book addBookPost(@RequestBody Book book){
		return bookService.save(book);
	}
}
