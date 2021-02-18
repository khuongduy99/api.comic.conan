package com.spring.dao;

import java.util.List;

import com.spring.model.Page;

public interface IPageDAO {
	List<Page> getAllByChapId(int id);
	
}
