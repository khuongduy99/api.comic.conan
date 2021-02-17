package com.spring.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.IChapDAO;
import com.spring.model.Chap;
import com.spring.service.IChapService;

@Service
public class ChapService implements IChapService{
	@Autowired
	private IChapDAO chapDAO;
	public List<Chap> getAll() {
		return chapDAO.getAll();
	}

	public Chap getOneById(int id) {
		return chapDAO.getOneById(id);
	}

	public List<Chap> getAllByBookId(int id) {
		return chapDAO.getAllByBookId(id);
	}

}
