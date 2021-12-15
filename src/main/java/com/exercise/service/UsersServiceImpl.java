package com.exercise.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.exercise.dao.UsersDAO;
import com.exercise.vo.Users;

@Service //구현하는 서비스 위에
public class UsersServiceImpl implements UsersService {
	
	@Inject
	UsersDAO dao;
	
	// 이메일 중복체크 처리
	// parameter : user_email
	// return : {
	//			0 : 사용가능
	//			1 : 중복
	//			}
	@Override
	public int emailCheck(String user_email) throws Exception {
		
		int result = 0;
		if(dao.emailCheck(user_email) != null) result = 1;
		return result;
		
	}
	
	// 닉네임 중복체크 처리
	// parameter : user_name
	// return : {
	//			0 : 사용가능
	//			1 : 중복
	//			}
	@Override
	public int nameCheck(String user_name) throws Exception {
		
		int result = 0;
		if(dao.nameCheck(user_name) != null) result = 1;
		return result;
		
	}
	
	// 이메일 찾기
	// parameter : user_name
	// return : {
	//			0 : 일치
	//			1 : 불일치
	//			}
	@Override
	public int findEmailAction(String user_name) throws Exception {
		
		int result = 0;
		if(dao.nameCheck(user_name) != null) result = 1;
		return result;
		
	}
	
	// 회원가입 처리
	// parameter : user_email
	@Override
	public void joinAction(Users users) throws Exception {
		dao.join(users);
	}
	
	// 로그인 처리
	// parameter : user_name
	// return : {
	//			Users 객체 : 일치
	//			null : 불일치
	//			}
	@Override
	public Users loginAction(Users users) throws Exception {

		return dao.loginAction(users);
	}
	

	@Override
	public int setAuthnum(String user_mail) throws Exception {

		return 0;
	}






	


}
