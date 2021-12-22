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
		// ���� ���� mapper�� emailCheck�� ã�ư��� user_email ����
		return sqlSession.selectOne(SESSION + ".emailCheck", user_email);

	}

	@Override
	public String nameCheck(String user_name) throws Exception {
		// ���� ���� mapper�� nameCheck�� ã�ư��� user_name ����
		return sqlSession.selectOne(SESSION + ".nameCheck", user_name);
	}

	@Override
	public void join(Users users) throws Exception {
		sqlSession.insert(SESSION + ".join", users);
	}

	@Override
	public String findEmailAction(String user_name) throws Exception {
		return sqlSession.selectOne(SESSION + ".findEmailAction", user_name);
	}
	
	@Override
	public Users findPwAction(Users users) throws Exception {
		return sqlSession.selectOne(SESSION + ".findPwAction", users);
	}

	@Override
	public void resetpw(Users users) throws Exception {
		// update, insert, delete�� int Ÿ���̰�, ��ȯ �� �ʿ� ��� void
		sqlSession.update(SESSION + ".resetPw", users);
	}

	@Override
	public Users loginAction(Users users) throws Exception {
		return sqlSession.selectOne(SESSION + ".loginAction", users);
	}




}
