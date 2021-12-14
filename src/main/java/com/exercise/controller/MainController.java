package com.exercise.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exercise.service.UsersService;
import com.exercise.vo.Users;

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
	
	// url ������ 'path/join'�� ���
	@RequestMapping(value =  "/join", method = RequestMethod.GET)
	public String join() throws Exception {
		
		return "main/join";
	}
	// url ������ 'path/login'�� ���
	@RequestMapping(value =  "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		
		return "main/login";
	}
	
	// url ������ 'path/findEmail'�� ���
	@RequestMapping(value =  "/findEmail", method = RequestMethod.GET)
	public String findEmail() throws Exception {
		
		return "main/findEmail";
	}
	
	
	// url ������ 'path/findPw'�� ���
	@RequestMapping(value =  "/findPw", method = RequestMethod.GET)
	public String findPw() throws Exception {
		
		return "main/findPw";
	}
	
	// url ������ 'path/emailCheck'�� ���
	// http://localhost:8088/emailCheck?
	@RequestMapping(value = "/emailCheck", method = RequestMethod.GET)
	// ��ȯ���� �������� ���
	@ResponseBody
	public String emailCheck(String user_email) throws Exception { //parameter
		
		int result = usersService.emailCheck(user_email);
		return result + ""; // ���ڿ� ��ȯ
			
	}
	
	// url ������ 'path/nameCheck'�� ���
	// http://localhost:8088/nameCheck?
	@RequestMapping(value = "/nameCheck", method = RequestMethod.GET)
	//��ȯ���� �������� ���
	@ResponseBody
	public String nameCheck(String user_name) throws Exception	{ //parameter
		
		int result = usersService.nameCheck(user_name);
		return result + "";
		
	}
	
	// url ������ 'path/joinAction'�� ���
	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(Users users) throws Exception {
		
		System.out.println(users.getUser_email());
		System.out.println(users.getUser_name());
		System.out.println(users.getUser_pw());
		System.out.println(users.getUser_gender());
		System.out.println(users.getUser_phone());
		usersService.joinAction(users);
		
		return "redirect:/login";
		// ���̴� url/joinAction ������ return ���� url
		// ȸ������ �� ���¿����� url ����������ϹǷ� redirect
		// redirect:/login == http://localhost:8088/login
	}
		
	// url ������ 'path/findEmailAction'�� ���
	@RequestMapping(value = "/findEmailAction", method = RequestMethod.POST)
	// POST ����� �ʿ���� responsebody �ʿ����
	public String findEmailAction(String user_name, RedirectAttributes ra) throws Exception {
		
		String result = usersService.findEmailAction(user_name);
		String url = null;
		
		
		if(result != null) {
			ra.addFlashAttribute("resultType", "email");
			// url �ڿ� ?resultType=email������ ����������
			ra.addFlashAttribute("result", "true");
			ra.addFlashAttribute("resultMsg", result);
			
			return url = "redirect:/findResult";
		}
		
		else {
			// �޼��� ���� (�г����� �߸��Ǿ����ϴ�.)
			ra.addFlashAttribute("resultType", "email");
			ra.addFlashAttribute("reuslt", "false");
			
			return url = "redirect:/findResult";
			
		}
	}
	
	// url ������ 'path/loginAction'�� ���
	@RequestMapping(value="/loginAction", method=RequestMethod.POST)
	public String loginAction(Users users,HttpSession session, RedirectAttributes ra) throws Exception{
		
		int result = usersService.loginAction(users);
		String url = null;
		
		if(result == 0) {
			
			session.setAttribute("user_Email", users.getUser_email());
			url = "redirect:/main";
			
		}
		
		else {
			ra.addFlashAttribute("msg", "�α��� ������ ��ġ���� �ʽ��ϴ�.");
			return url ="redirect:/login";
		}
	
		return url;
	}
	
	
	
	
	
	
	

}
