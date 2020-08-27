package com.ev.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ev.vo.ApiVO;

@Repository
public class ApiDaoImpl implements ApiDao {
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insert(ApiVO apivo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("apiMapper.insertapi", apivo);
		
	}
	@Override
	public void delete() throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("apiMapper.deleteapi");
		
	}
	@Override
	public void inc() throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("apiMapper.inc");
		
	}

	
}
