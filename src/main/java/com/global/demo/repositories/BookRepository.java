package com.global.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}