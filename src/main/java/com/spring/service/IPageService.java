package com.spring.service;

import java.util.List;

import com.spring.model.Page;

public interface IPageService {
	List<Page> getAllByChapId(int id);
}
