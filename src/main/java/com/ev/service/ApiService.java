package com.ev.service;

import com.ev.vo.ApiVO;

public interface ApiService {

	public void insert(ApiVO apivo) throws Exception;
	public void delete() throws Exception;
	public void inc() throws Exception;
	
}
