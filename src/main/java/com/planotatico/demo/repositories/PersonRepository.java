package com.planotatico.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.planotatico.demo.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>   {
    
}
