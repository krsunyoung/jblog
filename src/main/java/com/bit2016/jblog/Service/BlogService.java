package com.bit2016.jblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.vo.UserVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	public void insert(Long no){
		 blogDao.insert(no);
		
	}
}
