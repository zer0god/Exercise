package com.exercise.service;

import com.exercise.vo.Users;

// service를 구성할 interface 표준 설계 작성
public interface UsersService {
	
	public int emailCheck(String user_email) throws Exception;
	public int nameCheck(String user_name) throws Exception;
	public void joinAction(Users users) throws Exception; // 반환타입 필요없음
	public String findEmailAction(String user_name) throws Exception;
	public int loginAction(Users users) throws Exception;

	public int setAuthnum(String user_mail) throws Exception; 
	
}