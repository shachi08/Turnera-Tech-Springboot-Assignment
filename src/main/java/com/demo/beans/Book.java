package com.demo.beans;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Entity(name = "Book")
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;

    private String title;
    private String author;
    private String isbn;

    @OneToMany(
    		mappedBy = "book", 
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    private List<Page> pages=new ArrayList<>();
    
    
    


    public void addPages(Page page) {
    	pages.add(page);
        page.setBook(this);
    }
 
    public void removePage(Page page) {
        pages.remove(page);
        page.setBook(null);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Book() {
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Hello this book is saying........Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}

    
}