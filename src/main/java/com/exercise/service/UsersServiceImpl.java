package com.exercise.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.exercise.dao.UsersDAO;
import com.exercise.vo.Users;

@Service //�����ϴ� ���� ����
public class UsersServiceImpl implements UsersService {
	
	@Inject
	UsersDAO dao;
	
	// �̸��� �ߺ�üũ ó��
	// parameter : user_email
	// return : {
	//			0 : ��밡��
	//			1 : �ߺ�
	//			}
	@Override
	public int emailCheck(String user_email) throws Exception {
		
		int result = 0;
		if(dao.emailCheck(user_email) != null) result = 1;
		return result;
		
	}
	// �г��� �ߺ�üũ ó��
	// parameter : user_name
	// return : {
	//			0 : ��밡��
	//			1 : �ߺ�
	//			}
	@Override
	public int nameCheck(String user_name) throws Exception {
		
		int result = 0;
		if(dao.nameCheck(user_name) != null) result = 1;
		return result;
		
	}
	
	@Override
	public String findEmailAction(String user_email) throws Exception {
		
		return null;
	}
	
	@Override
	public void joinAction(Users users) throws Exception {
		dao.join(users);
	}
	
	// �α��� ó��
	// parameter : user_name
	// return : {
	//			0 : ��ġ
	//			1 : ����ġ
	//			}
	@Override
	public int loginAction(Users users) throws Exception {
		
		int result = 0;
		users = dao.login(users);
		
		if(users == null) result = 1;
		
		return result;
	}
	
	// �г��� �ߺ�üũ ó��
	// parameter : user_name
	// return : {
	//			0 : ��밡��
	//			1 : �ߺ�
	//			}

	
	// �̸��� ã��
	// parameter : user_nickname
	// return : {
	//			0 : ����
	//			1 : ����x
	//			}
	@Override
	public int setAuthnum(String user_mail) throws Exception {

		return 0;
	}






	


}
