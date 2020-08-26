package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Book;
import com.demo.repository.BookRepository;

@Service
public class BookService {

	
	@Autowired
	 private BookRepository brepo;
	// private Book book;
	
	public Book addOrUpdate(Book book) {
		return brepo.save(book);
	}
	public List<Book> getAllBooks(){
		return (List<Book>) brepo.findAll();
	}
}
