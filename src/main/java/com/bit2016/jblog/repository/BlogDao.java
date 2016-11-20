package com.bit2016.jblog.repository;

import java.util.HashMap;
import java.util.Map;

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
		
		public void titleUpdate(String title, String id){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", title);
			map.put("blog.getID", id);
			System.out.println(id);
			System.out.println(title);
			sqlSession.update("blog.titleUpdate",map);
		}
		
		public int imageupdate(BlogVo vo){
			return sqlSession.update("blog.imagaeupdate",vo);
		}
		
		public BlogVo getID(String id){
			return sqlSession.selectOne("blog.getID", id);
		}
}
