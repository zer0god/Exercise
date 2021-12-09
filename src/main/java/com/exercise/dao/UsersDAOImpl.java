package com.exercise.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAOImpl implements UsersDAO {
	
	@Inject
	SqlSession sqlSession;
	
	final String SESSION = "com.exercise.mappers.exercise";

	@Override
	public String nameCheck(String user_name) throws Exception {
		return sqlSession.selectOne(SESSION+ "nameCheck", user_name);
	}

	@Override
	public Integer getAuthnum(String user_mail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
