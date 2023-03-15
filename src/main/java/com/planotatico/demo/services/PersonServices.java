package com.planotatico.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.planotatico.demo.model.Person;


@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger loger = Logger.getLogger(PersonServices.class.getName());

    public List <Person> findAll(){
        loger.info("Find all persons: ");
        List<Person> persons= new ArrayList<>() ;
        for (int i= 0; i <8; i++){
                Person person = mockPerson(i);
                persons.add(person);
        }
        return persons;
    }


    public Person findById(String id){
        loger.info("Find one person: ");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Carlos ");
        person.setLastName("Alberto ");
        person.setAdress("Minas Gerais - Maria da fé ");
        person.setGender("Male ");
        return person;
    }

    public Person create(Person person) {
        loger.info("Creating one person: ");

        return person;
    }

    public Person update(Person person) {
        loger.info("Update one person: ");

        return person;
    }


    public void delete(String id) {
        loger.info("Deleting one person: ");

    }


    
    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name "+i);
        person.setLastName("Last name "+i);
        person.setAdress("Some addres in brazil "+i);
        person.setGender("Male "+i);
        return person;

    }
}
