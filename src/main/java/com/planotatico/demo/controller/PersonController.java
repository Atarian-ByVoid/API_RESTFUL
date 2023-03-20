package com.planotatico.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planotatico.demo.services.PersonServices;
import com.planotatico.demo.v1.PersonVO;
import com.planotatico.demo.v2.PersonVO_2;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    // procura todas as pessoas
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {
        return service.findAll();
    }




    

    // procura por id uma pessoa
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public PersonVO findById(@PathVariable(value = "id") Long id) {

        return service.findById(id);
    }




    // Cria uma pessoa
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)

    public PersonVO create(@RequestBody PersonVO person) {

        return service.create(person);
    }

        // Cria uma pessoa - V2
        @PostMapping(value="/v2",consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE)
    
        public PersonVO_2 createV2(@RequestBody PersonVO_2 person) {
    
            return service.createV2(person);
        }




    // Atualiza uma pessoa
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)

    public PersonVO update(@RequestBody PersonVO person) {

        return service.update(person);
    }





    // Deleta uma pessoa
    @DeleteMapping(value = "/{id}")

    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
