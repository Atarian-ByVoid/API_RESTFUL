package com.planotatico.demo.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.planotatico.demo.controller.PersonController;
import com.planotatico.demo.data.PersonVO;
import com.planotatico.demo.exceptions.RequiredObjectisNullExeception;
import com.planotatico.demo.exceptions.ResourcesNotFoundException;
import com.planotatico.demo.mapper.DozerMapper;
import com.planotatico.demo.model.Person;
import com.planotatico.demo.repositories.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;


    @Autowired
    PagedResourcesAssembler <PersonVO> assembler;


	public PagedModel<EntityModel<PersonVO>> findAll(Pageable pageable) {

		logger.info("Finding all people!");
		
		var personPage = repository.findAll(pageable);

		var personVosPage = personPage.map(p -> DozerMapper.parseObject(p, PersonVO.class));
		personVosPage.map(
			p -> p.add(
				linkTo(methodOn(PersonController.class)
					.findById(p.getKey())).withSelfRel()));
		
		Link link = linkTo(
			methodOn(PersonController.class)
				.findAll(pageable.getPageNumber(),
						pageable.getPageSize(),
						"asc")).withSelfRel();
		
		return assembler.toModel(personVosPage, link);
	}

	public PagedModel<EntityModel<PersonVO>> findPersonsByName(String firstname, Pageable pageable) {

		logger.info("Finding all people!");
		
		var personPage = repository.findPersonsByName(firstname, pageable);

		var personVosPage = personPage.map(p -> DozerMapper.parseObject(p, PersonVO.class));
		personVosPage.map(
			p -> p.add(
				linkTo(methodOn(PersonController.class)
					.findById(p.getKey())).withSelfRel()));
		
		Link link = linkTo(
			methodOn(PersonController.class)
				.findAll(pageable.getPageNumber(),
						pageable.getPageSize(),
						"asc")).withSelfRel();
		
		return assembler.toModel(personVosPage, link);
	}
	

    public PersonVO findById(Long id) {
        logger.info("Find one person: ");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));
        PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public PersonVO create(PersonVO person) {

        if (person == null)
            throw new RequiredObjectisNullExeception();
            logger.info("Creating one person: ");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO update(PersonVO person) {
        if (person == null)
            throw new RequiredObjectisNullExeception();

            logger.info("Update one person: ");

        var entity = repository.findById(person.getKey())
                .orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    @Transactional
    public PersonVO disablePerson(Long id) {

        logger.info("Find one person: ");

        repository.disablePerson(id);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));
        PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one person: ");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));

        repository.delete(entity);

    }

}
