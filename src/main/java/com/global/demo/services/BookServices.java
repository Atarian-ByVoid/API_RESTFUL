package com.global.demo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import com.global.demo.controller.BookController;
import com.global.demo.data.BookVO;
import com.global.demo.exceptions.RequiredObjectisNullExeception;
import com.global.demo.exceptions.ResourcesNotFoundException;
import com.global.demo.mapper.DozerMapper;
import com.global.demo.model.Book;
import com.global.demo.repositories.BookRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {

	private Logger logger = Logger.getLogger(BookServices.class.getName());

	@Autowired
	BookRepository repository;

	@Autowired
    PagedResourcesAssembler <BookVO> assembler;


	public PagedModel<EntityModel<BookVO>> findAll(Pageable pageable) {

		logger.info("Finding all people!");
		
		var personPage = repository.findAll(pageable);

		var booksVosPage = personPage.map(p -> DozerMapper.parseObject(p, BookVO.class));
		booksVosPage.map(
			p -> p.add(
				linkTo(methodOn(BookController.class)
					.findById(p.getKey())).withSelfRel()));
		
		Link link = linkTo(
			methodOn(BookController.class)
				.findAll(pageable.getPageNumber(),
						pageable.getPageSize(),
						"asc")).withSelfRel();
		
		return assembler.toModel(booksVosPage, link);
	}
	

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