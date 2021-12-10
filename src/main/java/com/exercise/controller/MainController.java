package com.exercise.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exercise.service.UsersService;

// url 전송 : http://localhost:8088/

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// 객체 생성
	@Inject
	UsersService usersService;
	
	// 경로 찾아가기
	// url 패턴이 'path/'인 경우
	@RequestMapping(value =  "/", method = RequestMethod.GET)
	public String main(HttpSession session) throws Exception {
		
		if(session.getAttribute("user") ==  null) return "main/login";
		
		return "main/main";
	}
	
	// 경로 찾아가기
	// url 패턴이 'path/join'인 경우
	@RequestMapping(value =  "/join", method = RequestMethod.GET)
	public String join() throws Exception {
		
		return "main/join";
	}

}
