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

import com.spring.model.Page;
import com.spring.service.IPageService;

@RestController
public class PageRestController {
	@Autowired
	private IPageService pageService;
	
	/* ---------------- GET ALL PAGE BY CHAP ------------------------ */
	@RequestMapping(value = "/chap/{id}/pages", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Page>> getAllByChap(@PathVariable int id) {
		List<Page> list = pageService.getAllByChapId(id);
		if (list == null) return new ResponseEntity<List<Page>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Page>>(list, HttpStatus.OK);
	}
}
