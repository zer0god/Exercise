package com.exercise.service;

import com.exercise.vo.Users;

// service�� ������ interface ǥ�� ���� �ۼ�
public interface UsersService {
	
	public int emailCheck(String user_email) throws Exception;
	public int nameCheck(String user_name) throws Exception;
	public void joinAction(Users users) throws Exception; // ��ȯŸ�� �ʿ����
	public String findEmailAction(String user_name) throws Exception;
	public int findPwAction(Users users) throws Exception;
	public Users loginAction(Users users) throws Exception;

}