package com.exercise.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exercise.service.HomeService;

@Controller
@RequestMapping(value = "/exercise/*")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// 객체 생성
	@Inject
	HomeService homeService;
	
	// 경로 찾아가기
	// url 패턴이 'path/exercise/'인 경우
	@RequestMapping(value = "/", method =  RequestMethod.GET)
	public String home(RedirectAttributes ra, HttpSession session) throws Exception{
		
		// 로그인이 안되어있으면 로그인 페이지 이동
		if(session.getAttribute("user_email") == null) {
			ra.addFlashAttribute("msg", "로그인이 필요합니다.");
			return "redirect:/";
		}
		
		// 로그인이 되어있으면 홈 출력
		return "main/main";
	}
}
