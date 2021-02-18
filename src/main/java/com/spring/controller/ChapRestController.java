package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	@RequestMapping(value = "/chaps", method = RequestMethod.GET)
	public ResponseEntity<List<Chap>> getAll() {
		List<Chap> list = chapService.getAll();
		return new ResponseEntity<List<Chap>>(list, HttpStatus.OK);
	}

	/* ---------------- GET ONE CHAP ------------------------ */
	@RequestMapping(value = "/chaps/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Chap>> getChapByBookId(@PathVariable int id) {
		List<Chap> list = chapService.getAllByBookId(id);
		if (list == null)
			return new ResponseEntity<List<Chap>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Chap>>(list, HttpStatus.OK);

	}
}
