package com.exercise.dao;

public interface UsersDAO {
	
	public String nameCheck(String user_name) throws Exception;
	public Integer getAuthnum(String user_mail) throws Exception;

}
