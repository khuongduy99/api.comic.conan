package com.spring.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.IPageDAO;
import com.spring.model.Page;
import com.spring.service.IPageService;

@Service
public class PageService implements IPageService{
	
	@Autowired
	private IPageDAO pageDAO;

	public List<Page> getAllByChapId(int id) {
		
		return pageDAO.getAllByChapId(id);
	}

}
