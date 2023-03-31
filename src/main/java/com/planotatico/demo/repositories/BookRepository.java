package com.planotatico.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.planotatico.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}