package com.exercise.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exercise.service.UsersService;

// url 傈价 : http://localhost:8088/

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// 按眉 积己
	@Inject
	UsersService usersService;
	
	@RequestMapping(value =  "/join", method = RequestMethod.GET)
	public String join(Model model) throws Exception {
		return "main/join";
	}

}
