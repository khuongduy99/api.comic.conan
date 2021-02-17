package com.spring.dao;

import java.util.List;

import com.spring.model.Book;

public interface IBookDAO {
	List<Book> getAll();
	Book getOneById(int id);
}
