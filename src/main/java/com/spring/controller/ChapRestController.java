package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Chap;
import com.spring.service.IChapService;

@RestController
public class ChapRestController {
	
	@Autowired
	private IChapService chapService;
	
	/* ---------------- GET ALL CHAP ------------------------ */
	@RequestMapping(value = "/chaps", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Chap>> getAll() {
		List<Chap> list = chapService.getAll();
		return new ResponseEntity<List<Chap>>(list, HttpStatus.OK);
	}

	/* ---------------- GET ONE CHAP ------------------------ */
	@RequestMapping(value = "/chap/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Chap> getChapByBookId(@PathVariable int id) {
		Chap model = chapService.getOneById(id);
		if (model == null)
			return new ResponseEntity<Chap>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Chap>(model, HttpStatus.OK);

	}
	
	/* ---------------- GET ALL CHAP OF ONE BOOK ------------------------ */
	@RequestMapping(value = "/book/{id}/chaps", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Chap>> getAllChapByIdBook(@PathVariable int id) {
		List<Chap> list = chapService.getAllByBookId(id);
		if (list == null)
			return new ResponseEntity<List<Chap>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Chap>>(list, HttpStatus.OK);

	}
}
