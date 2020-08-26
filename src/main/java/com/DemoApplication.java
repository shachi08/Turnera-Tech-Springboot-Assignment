package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.beans.Book;
import com.demo.beans.Page;
import com.demo.repository.BookRepository;
import com.demo.repository.PageRepository;

@SpringBootApplication
@ComponentScan({"com.demo"})
@EnableJpaRepositories("com.demo.repository")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner mappingDemo(BookRepository bookRepository,
                                         PageRepository pageRepository) {
        return args -> {

            // create a new book
            Book book = new Book("Java 101", "John Doe", "12356");

            // save the book
            bookRepository.save(book);

            // create and save new pages
            pageRepository.save(new Page(1, "Introduction contents", "Introduction",book));
            pageRepository.save(new Page(65, "Java 8 contents", "Java 8",book));
          //  pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));
        };
    }
}