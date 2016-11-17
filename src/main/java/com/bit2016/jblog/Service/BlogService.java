package com.bit2016.jblog.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.CategoryVo;

@Service
public class BlogService {
	
//	@Autowired
//	private BlogDao blogDao;
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	public List<CategoryVo> getList(String userId){
		return categoryDao.getList(userId);
	}
	
	
	public boolean getByNo(String id) {
		return (userDao.getByNo(id) !=null);
	}
}
