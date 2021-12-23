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
	
	// ��ü ����
	@Inject
	HomeService homeService;
	
	// ��� ã�ư���
	// url ������ 'path/exercise/'�� ���
	@RequestMapping(value = "/", method =  RequestMethod.GET)
	public String home(RedirectAttributes ra, HttpSession session) throws Exception{
		
		// �α����� �ȵǾ������� �α��� ������ �̵�
		if(session.getAttribute("user_email") == null) {
			ra.addFlashAttribute("msg", "�α����� �ʿ��մϴ�.");
			return "redirect:/";
		}
		
		// �α����� �Ǿ������� Ȩ ���
		return "main/main";
	}
}
