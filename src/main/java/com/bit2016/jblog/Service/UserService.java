package com.bit2016.jblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public Long join(UserVo vo){
		return userDao.insert(vo);
		
	}
	public UserVo login(String id, String password) {
		UserVo userVo = null;
		userVo = userDao.get(id, password);
		return userVo;
	}

	public boolean idExist(String id){
		return (userDao.get(id)!=null);
	}
	
	
	
}
