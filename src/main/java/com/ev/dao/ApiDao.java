package com.ev.dao;
import java.util.*;

import com.ev.vo.ApiVO;
public interface ApiDao {
	
	public void insert(ApiVO apivo) throws Exception;
	public void delete() throws Exception;
	public void inc() throws Exception;
}
