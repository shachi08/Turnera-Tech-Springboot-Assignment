package com.demo.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.demo.beans.Book;
import com.demo.beans.Page;

import java.util.List;


@Repository
public interface PageRepository extends CrudRepository<Page, Long> {

    //List<Page> findByBook(Book book, Sort sort);
}