package com.bit2016.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void insert(Long no){
		sqlSession.insert("category.insert", no );
	}
	
	public List<CategoryVo> getList(String userId) {
		System.out.println(sqlSession.selectList("category.getList", "123"));
		return sqlSession.selectList("category.getList", userId);
	}
	
}
