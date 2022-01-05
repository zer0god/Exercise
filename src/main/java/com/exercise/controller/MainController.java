package com.exercise.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exercise.service.DaysService;
import com.exercise.service.UsersService;
import com.exercise.vo.Part_Data;
import com.exercise.vo.Part_Sporting;
import com.exercise.vo.Users;

// url 전송 : http://localhost:8088/

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// 객체 생성
	@Inject
	UsersService usersService;
	@Inject
	DaysService daysService;
	
	// 경로 찾아가기
	// url 패턴이 'path/'인 경우
	@RequestMapping(value =  "/", method = RequestMethod.GET)
	public String main(HttpSession session) throws Exception {
		
		Users users = (Users) session.getAttribute("users");
		
		if(users ==  null) return "main/login";
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM%");
		
		Map<String, List<Part_Sporting>> data = daysService.getDateData(sdf.format(date), users.getUser_email());
		// service에 sdf 보내주기
		// Part_Sporting 꼬리부분
		
		// view 폴더의 "mail", 만약 views/main/main이면 "main/main"
		return "main/main";
	}
	
	// url 패턴이 'path/join'인 경우
	@RequestMapping(value =  "/join", method = RequestMethod.GET)
	public String join() throws Exception {
		
		return "main/join";
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
	
	// url 패턴이 'path/findResult'인 경우
	@RequestMapping(value =  "/findResult", method = RequestMethod.GET)
	public String findResult() throws Exception {
		
		return "main/findResult";
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
	// 반환값을 페이지에 출력
	@ResponseBody
	public String nameCheck(String user_name) throws Exception	{ //parameter
		
		int result = usersService.nameCheck(user_name);
		return result + "";
		
	}
	
	// url 패턴이 'path/joinAction'인 경우
	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(Users users) throws Exception {

		usersService.joinAction(users);
		
		return "redirect:/";
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
	
	// url 패턴이 'path/findPwAction'인 경우
	@RequestMapping(value="/findPwAction", method=RequestMethod.POST)
	public String findPwAction(Users users, RedirectAttributes ra) throws Exception{
		
		int result = usersService.findPwAction(users);
		
		if(result != -1) {
			
			ra.addFlashAttribute("resultType", "password");
			ra.addFlashAttribute("result", "true");
			ra.addFlashAttribute("resultMsg", result);
			
			return "redirect:/findResult";
		}
		
		else {
			
			ra.addFlashAttribute("resultType", "password");
			ra.addFlashAttribute("result", "false");
			
			return "redirect:/findResult";
			
		}
	}
	
	
	// url 패턴이 'path/loginAction'인 경우
	@RequestMapping(value="/loginAction", method=RequestMethod.POST)
	public String loginAction(Users users,HttpSession session, RedirectAttributes ra) throws Exception{
		
		Users result = usersService.loginAction(users);
		String url = null;
		
		if(result != null) {
			session.setAttribute("users", users);
			url = "redirect:/";
		}
		
		else {
			ra.addFlashAttribute("msg", "로그인 정보가 일치하지 않습니다.");
			url ="redirect:/";
		}
		
		return url;
		
	}
	
	// url 패턴이 'path/days'인 경우
	@RequestMapping(value="/days", method=RequestMethod.GET)
	@ResponseBody
	// @ResponseBody가 없을 때 0이 들어가면 URL이 0인 곳으로 이동.
	public String days(String date, HttpSession session) throws Exception{
		
		// session에서 users 값 불러와서 users에 저장
		// service에서 사용 할 user_email에 필요함. 
		Users users = (Users) session.getAttribute("users");
		
		// service에서 users에 담겨있는 days_id를 저장
		String days_id = daysService.days(users, date);
		
		return days_id;
	}
	
	// url 패턴이 'path/part_sporting'인 경우
	@RequestMapping(value="/part_sporting", method=RequestMethod.GET)
	@ResponseBody
	public List<Part_Sporting> part_sporting(Part_Sporting part_sporting) throws Exception{
		// view에서 part_sporting 입력 받아옴
		// part_sporting 안에 두개의 id가 들어있음

		// service에서 part_sporting과 days를 이용해서 part_sporting_id를 만들고 저장
		// 가져오고 받는 것 다 포함
		List<Part_Sporting> part_sporting_id = daysService.part_sporting(part_sporting);
		
		return part_sporting_id;
	}
	
	// url 패턴이 'path/part_data'인 경우
	@RequestMapping(value="/part_data", method=RequestMethod.GET)
	@ResponseBody
	public List<Part_Data> part_data(Part_Data part_data) throws Exception{
		// view에서 part_data 입력 받아옴
		// part_data 안에 두개의 id가 다 들어있음
		
		// service에서 part_sporting과 part를 이용해서 part_data_id를 만들고 저장
		//String part_data_id = daysService.part_data(part_data);
		List<Part_Data> part_data_id = daysService.part_data(part_data);
		
		return part_data_id;
	}
	
	
	
	
	
	

}
