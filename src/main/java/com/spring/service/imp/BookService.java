package com.spring.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.IBookDAO;
import com.spring.model.Book;
import com.spring.service.IBookService;

@Service
public class BookService implements IBookService{
	
	@Autowired
	private IBookDAO bookDAO;

	public List<Book> getAll() {
		return bookDAO.getAll();
	}

	public Book getOneById(int id) {
		return bookDAO.getOneById(id);
	}

}
