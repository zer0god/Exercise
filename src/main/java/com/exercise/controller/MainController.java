package com.exercise.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exercise.service.UsersService;

// url ���� : http://localhost:8088/

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// ��ü ����
	@Inject
	UsersService usersService;
	
	// ��� ã�ư���
	// url ������ 'path/'�� ���
	@RequestMapping(value =  "/", method = RequestMethod.GET)
	public String main(HttpSession session) throws Exception {
		
		if(session.getAttribute("user") ==  null) return "main/login";
		
		return "main/main";
	}
	
	// ��� ã�ư���
	// url ������ 'path/join'�� ���
	@RequestMapping(value =  "/join", method = RequestMethod.GET)
	public String join() throws Exception {
		
		return "main/join";
	}

}
