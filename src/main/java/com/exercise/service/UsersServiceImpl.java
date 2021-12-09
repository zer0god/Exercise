package com.exercise.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.exercise.dao.UsersDAO;

@Service //구현하는 서비스 위에
public class UsersServiceImpl implements UsersService {
	
	@Inject
	UsersDAO dao;

	@Override
	public int nameCheck(String user_name) throws Exception {
		int result = 0;
		if(dao.nameCheck(user_name) != null) result = 1;
		
		return result;
	}

	@Override
	public int setAuthnum(String user_mail) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
