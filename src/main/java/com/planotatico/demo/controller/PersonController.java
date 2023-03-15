package com.planotatico.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planotatico.demo.model.Person;
import com.planotatico.demo.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service = new PersonServices();
    // private PersonServices service = new PersonServices();

    @RequestMapping(value = "{id}", 
    method = RequestMethod.GET, 
    produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)

    public Person findById(@PathVariable(value = "id") String id) {

        return service.findById(id);
    }



    @RequestMapping(method = RequestMethod.POST, 
    consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, 
    produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)

    public Person create(@RequestBody Person person) {

        return service.create(person);
    }



    @RequestMapping(method = RequestMethod.PUT, 
    consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, 
    produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)

    public Person update(@RequestBody Person person) {

        return service.update(person);
    }

    @RequestMapping(value = "{id}", 
    method = RequestMethod.DELETE)

    public void delete(@PathVariable(value = "id") String id) {

         service.delete(id);
    }




    @RequestMapping(method = RequestMethod.GET, 
    produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)

    public List<Person> findAll() {

        return service.findAll();
    }

}
