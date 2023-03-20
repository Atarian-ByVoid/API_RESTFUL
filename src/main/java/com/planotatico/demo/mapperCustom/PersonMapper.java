package com.planotatico.demo.mapperCustom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.planotatico.demo.model.Person;
import com.planotatico.demo.v2.PersonVO_2;

@Service
public class PersonMapper {

    public PersonVO_2 convertEntityToVo(Person person) {
        PersonVO_2 vo= new PersonVO_2();
        vo.setId(person.getId());
        vo.setAdress(person.getAdress());
        vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());

        return vo;
    }

    public Person convertVoTOEntity(PersonVO_2 person) {
        Person entity= new Person();
        entity.setId(person.getId());
        entity.setAdress(person.getAdress());
        //vo.setBirthDay(new Date());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());

        return entity;
    }

    

    
    
}
