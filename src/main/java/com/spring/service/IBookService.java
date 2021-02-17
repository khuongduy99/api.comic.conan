package com.spring.service;

import java.util.List;

import com.spring.model.Book;

public interface IBookService {
	List<Book> getAll();
	Book getOneById(int id);
}
