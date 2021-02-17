package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Book;
import com.spring.service.IBookService;

@RestController
public class BookRestController {
	
	@Autowired
	private IBookService bookService;
	
	/* ---------------- GET ALL BOOK ------------------------ */
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getAll() {
		List<Book> list = bookService.getAll();
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	/* ---------------- GET ONE BOOK ------------------------ */
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		Book model = bookService.getOneById(id);
		if (model == null)
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Book>(model, HttpStatus.OK);

	}
}
