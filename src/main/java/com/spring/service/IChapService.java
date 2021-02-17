package com.spring.service;

import java.util.List;

import com.spring.model.Chap;

public interface IChapService {
	List<Chap> getAll();
	List<Chap> getAllByBookId(int id);
	Chap getOneById(int id);
}
	