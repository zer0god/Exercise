package com.exercise.service;

// service를 구성할 interface 표준 설계 작성
public interface UsersService {
	
	public int nameCheck(String user_name) throws Exception;
	public int setAuthnum(String user_mail) throws Exception;

}
