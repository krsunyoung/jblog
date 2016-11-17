package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDao {
	
		@Autowired
		private SqlSession sqlSession;
		
		public void insert(Long no){
			sqlSession.insert("blog.create", no);
		}
		
		public int imageinsert(String logo){
			
			return sqlSession.update("blog.imagaeupdate",logo);
		}
		
}
