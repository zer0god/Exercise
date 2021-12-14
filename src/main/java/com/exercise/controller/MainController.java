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
	
	// url 패턴이 'path/join'인 경우
	@RequestMapping(value =  "/join", method = RequestMethod.GET)
	public String join() throws Exception {
		
		return "main/join";
	}
	// url 패턴이 'path/login'인 경우
	@RequestMapping(value =  "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		
		return "main/login";
	}
	
	// url 패턴이 'path/findEmail'인 경우
	@RequestMapping(value =  "/findEmail", method = RequestMethod.GET)
	public String findEmail() throws Exception {
		
		return "main/findEmail";
	}
	
	
	// url 패턴이 'path/findPw'인 경우
	@RequestMapping(value =  "/findPw", method = RequestMethod.GET)
	public String findPw() throws Exception {
		
		return "main/findPw";
	}
	
	// url 패턴이 'path/emailCheck'인 경우
	// http://localhost:8088/emailCheck?
	@RequestMapping(value = "/emailCheck", method = RequestMethod.GET)
	// 반환값을 페이지에 출력
	@ResponseBody
	public String emailCheck(String user_email) throws Exception { //parameter
		
		int result = usersService.emailCheck(user_email);
		return result + ""; // 문자열 전환
			
	}
	
	// url 패턴이 'path/nameCheck'인 경우
	// http://localhost:8088/nameCheck?
	@RequestMapping(value = "/nameCheck", method = RequestMethod.GET)
	//반환값을 페이지에 출력
	@ResponseBody
	public String nameCheck(String user_name) throws Exception	{ //parameter
		
		int result = usersService.nameCheck(user_name);
		return result + "";
		
	}
	
	// url 패턴이 'path/joinAction'인 경우
	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(Users users) throws Exception {
		
		System.out.println(users.getUser_email());
		System.out.println(users.getUser_name());
		System.out.println(users.getUser_pw());
		System.out.println(users.getUser_gender());
		System.out.println(users.getUser_phone());
		usersService.joinAction(users);
		
		return "redirect:/login";
		// 보이는 url/joinAction 실제는 return 값의 url
		// 회원가입 된 상태에서는 url 변경해줘야하므로 redirect
		// redirect:/login == http://localhost:8088/login
	}
		
	// url 패턴이 'path/findEmailAction'인 경우
	@RequestMapping(value = "/findEmailAction", method = RequestMethod.POST)
	// POST 결과값 필요없음 responsebody 필요없음
	public String findEmailAction(String user_name, RedirectAttributes ra) throws Exception {
		
		String result = usersService.findEmailAction(user_name);
		String url = null;
		
		
		if(result != null) {
			ra.addFlashAttribute("resultType", "email");
			// url 뒤에 ?resultType=email이지만 보이지않음
			ra.addFlashAttribute("result", "true");
			ra.addFlashAttribute("resultMsg", result);
			
			return url = "redirect:/findResult";
		}
		
		else {
			// 메세지 전달 (닉네임이 잘못되었습니다.)
			ra.addFlashAttribute("resultType", "email");
			ra.addFlashAttribute("reuslt", "false");
			
			return url = "redirect:/findResult";
			
		}
	}
	
	// url 패턴이 'path/loginAction'인 경우
	@RequestMapping(value="/loginAction", method=RequestMethod.POST)
	public String loginAction(Users users,HttpSession session, RedirectAttributes ra) throws Exception{
		
		int result = usersService.loginAction(users);
		String url = null;
		
		if(result == 0) {
			
			session.setAttribute("user_Email", users.getUser_email());
			url = "redirect:/main";
			
		}
		
		else {
			ra.addFlashAttribute("msg", "로그인 정보가 일치하지 않습니다.");
			return url ="redirect:/login";
		}
	
		return url;
	}
	
	
	
	
	
	
	

}
