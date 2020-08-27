package com.ev.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ev.dao.ApiDao;
import com.ev.vo.ApiVO;

@Service
public class ApiServiceImpl implements ApiService {
	
	@Inject
	private ApiDao dao;

	@Override
	public void insert(ApiVO apivo) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(apivo);
	}
	@Override
	public void delete() throws Exception {
		// TODO Auto-generated method stub
		dao.delete();
	}
	
	@Override
	public void inc() throws Exception {
		// TODO Auto-generated method stub
		dao.inc();
	}
	
	
}
