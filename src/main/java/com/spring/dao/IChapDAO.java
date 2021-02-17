package com.spring.dao;

import java.util.List;

import com.spring.model.Chap;

public interface IChapDAO {
	List<Chap> getAll();
	List<Chap> getAllByBookId(int id);
	Chap getOneById(int id);
}
	