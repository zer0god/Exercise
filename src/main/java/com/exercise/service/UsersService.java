package com.exercise.service;

// service�� ������ interface ǥ�� ���� �ۼ�
public interface UsersService {
	
	public int nameCheck(String user_name) throws Exception;
	public int setAuthnum(String user_mail) throws Exception;

}
