package com.planotatico.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planotatico.demo.exceptions.ResourcesNotFoundException;
import com.planotatico.demo.model.Person;
import com.planotatico.demo.repositories.PersonRepository;

@Service
public class PersonServices {

    private Logger loger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        loger.info("Find all persons: ");

        return repository.findAll();
    }

    public Person findById(Long id) {
        loger.info("Find one person: ");
   
        return repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));
    }

    public Person create(Person person) {
        loger.info("Creating one person: ");

        return repository.save(person);
    }

    public Person update(Person person) {
        loger.info("Update one person: ");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));

                entity.setFirstName(person.getFirstName());
                entity.setLastName(person.getLastName());
                entity.setAdress(person.getAdress());
                entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id) {
        loger.info("Deleting one person: ");


        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));

                repository.delete(entity);


    }

}
