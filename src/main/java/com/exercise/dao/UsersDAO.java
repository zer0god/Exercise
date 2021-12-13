package com.exercise.dao;

import com.exercise.vo.Users;

public interface UsersDAO {
	
	public String emailCheck(String user_email) throws Exception;
	public String nameCheck(String user_name) throws Exception;
	public void join(Users users) throws Exception;
	public String findEmailAction(String user_emali) throws Exception;
	
	

}
