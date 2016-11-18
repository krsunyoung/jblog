package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.BlogVo;

@Repository
public class BlogDao {
	
		@Autowired
		private SqlSession sqlSession;
		
		public void insert(Long no){
			sqlSession.insert("blog.create", no);
		}
		
		public void titleUpdate(BlogVo vo){
			sqlSession.update("blog.titleUpdate",vo	);
		}
		
		public int imageupdate(BlogVo vo){
			return sqlSession.update("blog.imagaeupdate",vo);
		}
		
		public BlogVo getID(String id){
			return sqlSession.selectOne("blog.getID", id);
		}
}
