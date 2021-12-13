package com.exercise.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.exercise.vo.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {
	
	@Inject
	SqlSession sqlSession;
	
	final String SESSION = "com.exercise.mappers.exercise";
	
	@Override
	public String emailCheck(String user_email) throws Exception {
		// 세션 접속 mapper의 emailCheck를 찾아가서 user_email 저장
		return sqlSession.selectOne(SESSION + ".emailCheck", user_email);

	}

	@Override
	public String nameCheck(String user_name) throws Exception {
		// 세션 접속 mapper의 nameCheck를 찾아가서 user_name 저장
		return sqlSession.selectOne(SESSION + ".nameCheck", user_name);
	}

	@Override
	public void join(Users users) throws Exception {
		sqlSession.insert(SESSION + ".join", users);
	}

	@Override
	public String findEmailAction(String user_email) throws Exception {
		return sqlSession.selectOne(SESSION + ".findEmailAction", user_email);
	}

}
