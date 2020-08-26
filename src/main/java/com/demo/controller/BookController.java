package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Book;
import com.demo.repository.BookRepository;
import com.demo.service.BookService;

@CrossOrigin
@RestController
@RequestMapping("/rest_booksresource")
public class BookController {


	public BookController() {
		System.out.println("controller starts....");
		// TODO Auto-generated constructor stub
	}
@Autowired
BookService bservice;

//http username is "spring" & password is "test123"

 //hit the url "http://localhost:8081/rest_booksresource/books" select "GET" option for getting the list of records

	//getAll users
	@GetMapping("books")
	public List<Book> listBooks()
	{
		System.out.println("m in controller....");
		return  (List<Book>) bservice.getAllBooks();
		
	}
	
	
	//hit url "http://localhost:8081/rest_booksresource/newbook" select "POST" option for adding new record
	//create new record..
		@PostMapping("newbook")
		public Book postData(@Validated @RequestBody Book book)
		{
			System.out.println("m working in post method");
			System.out.println(book);
			bservice.addOrUpdate(book);
			return book;
		}
}