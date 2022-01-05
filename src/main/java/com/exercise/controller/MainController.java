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

// url ���� : http://localhost:8088/

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// ��ü ����
	@Inject
	UsersService usersService;
	@Inject
	DaysService daysService;
	
	// ��� ã�ư���
	// url ������ 'path/'�� ���
	@RequestMapping(value =  "/", method = RequestMethod.GET)
	public String main(HttpSession session) throws Exception {
		
		Users users = (Users) session.getAttribute("users");
		
		if(users ==  null) return "main/login";
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM%");
		
		Map<String, List<Part_Sporting>> data = daysService.getDateData(sdf.format(date), users.getUser_email());
		// service�� sdf �����ֱ�
		// Part_Sporting �����κ�
		
		// view ������ "mail", ���� views/main/main�̸� "main/main"
		return "main/main";
	}
	
	// url ������ 'path/join'�� ���
	@RequestMapping(value =  "/join", method = RequestMethod.GET)
	public String join() throws Exception {
		
		return "main/join";
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
	
	// url ������ 'path/findResult'�� ���
	@RequestMapping(value =  "/findResult", method = RequestMethod.GET)
	public String findResult() throws Exception {
		
		return "main/findResult";
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
	// ��ȯ���� �������� ���
	@ResponseBody
	public String nameCheck(String user_name) throws Exception	{ //parameter
		
		int result = usersService.nameCheck(user_name);
		return result + "";
		
	}
	
	// url ������ 'path/joinAction'�� ���
	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(Users users) throws Exception {

		usersService.joinAction(users);
		
		return "redirect:/";
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
	
	// url ������ 'path/findPwAction'�� ���
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
	
	
	// url ������ 'path/loginAction'�� ���
	@RequestMapping(value="/loginAction", method=RequestMethod.POST)
	public String loginAction(Users users,HttpSession session, RedirectAttributes ra) throws Exception{
		
		Users result = usersService.loginAction(users);
		String url = null;
		
		if(result != null) {
			session.setAttribute("users", users);
			url = "redirect:/";
		}
		
		else {
			ra.addFlashAttribute("msg", "�α��� ������ ��ġ���� �ʽ��ϴ�.");
			url ="redirect:/";
		}
		
		return url;
		
	}
	
	// url ������ 'path/days'�� ���
	@RequestMapping(value="/days", method=RequestMethod.GET)
	@ResponseBody
	// @ResponseBody�� ���� �� 0�� ���� URL�� 0�� ������ �̵�.
	public String days(String date, HttpSession session) throws Exception{
		
		// session���� users �� �ҷ��ͼ� users�� ����
		// service���� ��� �� user_email�� �ʿ���. 
		Users users = (Users) session.getAttribute("users");
		
		// service���� users�� ����ִ� days_id�� ����
		String days_id = daysService.days(users, date);
		
		return days_id;
	}
	
	// url ������ 'path/part_sporting'�� ���
	@RequestMapping(value="/part_sporting", method=RequestMethod.GET)
	@ResponseBody
	public List<Part_Sporting> part_sporting(Part_Sporting part_sporting) throws Exception{
		// view���� part_sporting �Է� �޾ƿ�
		// part_sporting �ȿ� �ΰ��� id�� �������

		// service���� part_sporting�� days�� �̿��ؼ� part_sporting_id�� ����� ����
		// �������� �޴� �� �� ����
		List<Part_Sporting> part_sporting_id = daysService.part_sporting(part_sporting);
		
		return part_sporting_id;
	}
	
	// url ������ 'path/part_data'�� ���
	@RequestMapping(value="/part_data", method=RequestMethod.GET)
	@ResponseBody
	public List<Part_Data> part_data(Part_Data part_data) throws Exception{
		// view���� part_data �Է� �޾ƿ�
		// part_data �ȿ� �ΰ��� id�� �� �������
		
		// service���� part_sporting�� part�� �̿��ؼ� part_data_id�� ����� ����
		//String part_data_id = daysService.part_data(part_data);
		List<Part_Data> part_data_id = daysService.part_data(part_data);
		
		return part_data_id;
	}
	
	
	
	
	
	

}
