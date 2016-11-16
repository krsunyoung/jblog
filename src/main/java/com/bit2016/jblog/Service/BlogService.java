package com.bit2016.jblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.UserDao;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private UserDao userDao;
	
	public void insert(Long no){
		 blogDao.insert(no);
		
	}
	
	public boolean getByNo(String id) {
		return (userDao.getByNo(id) !=null);
	}
}
