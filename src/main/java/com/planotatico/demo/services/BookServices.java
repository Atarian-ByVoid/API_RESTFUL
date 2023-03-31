package com.planotatico.demo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planotatico.demo.controller.BookController;
import com.planotatico.demo.exceptions.RequiredObjectisNullExeception;
import com.planotatico.demo.exceptions.ResourcesNotFoundException;
import com.planotatico.demo.mapper.DozerMapper;
import com.planotatico.demo.model.Book;
import com.planotatico.demo.repositories.BookRepository;
import com.planotatico.demo.v1.BookVO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {

	private Logger logger = Logger.getLogger(BookServices.class.getName());

	@Autowired
	BookRepository repository;

	public List<BookVO> findAll() {

		logger.info("Finding all book!");

		var books = DozerMapper.parseListObject(repository.findAll(), BookVO.class);
		books
				.stream()
				.forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
		return books;
	}

	public BookVO findById(Long id) {
		logger.info("Find one person: ");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));
		BookVO vo = DozerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return vo;
	}

	public BookVO create(BookVO book) {

		if (book == null)
			throw new RequiredObjectisNullExeception();

		logger.info("Creating one book!");
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public BookVO update(BookVO book) {

		if (book == null)
			throw new RequiredObjectisNullExeception();

		logger.info("Updating one book!");

		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));

		entity.setId(book.getKey());
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());


		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one book!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("No records found by ID!"));

		repository.delete(entity);

	}
}
