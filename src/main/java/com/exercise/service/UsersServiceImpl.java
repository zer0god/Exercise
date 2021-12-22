package com.exercise.service;

import java.util.Properties;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.exercise.dao.UsersDAO;
import com.exercise.util.Mail;
import com.exercise.vo.Users;

@Service //구현하는 서비스 위에
public class UsersServiceImpl implements UsersService {
	
	@Inject
	UsersDAO dao;
	
	// 이메일 중복체크 처리
	// parameter : user_email
	// return : {
	//			0 : 사용가능
	//			1 : 중복
	//			}
	@Override
	public int emailCheck(String user_email) throws Exception {
		
		int result = 0;
		if(dao.emailCheck(user_email) != null) result = 1;
		return result;
		
	}
	
	// 닉네임 중복체크 처리
	// parameter : user_name
	// return : {
	//			0 : 사용가능
	//			1 : 중복
	//			}
	@Override
	public int nameCheck(String user_name) throws Exception {
		
		int result = 0;
		if(dao.nameCheck(user_name) != null) result = 1;
		return result;
		
	}
	
	// 회원가입 처리
	// parameter : user_email
	@Override
	public void joinAction(Users users) throws Exception {
		dao.join(users);
	}
	
	// 이메일 찾기
	// parameter : user_name
	// return : {
	//			0 : 일치
	//			1 : 불일치
	//			}
	@Override
	public String findEmailAction(String user_name) throws Exception {
		
		String result = null;
		String user_email = dao.findEmailAction(user_name);
		StringBuilder builder = new StringBuilder(user_email);
		
		// String[] arr = user_email.split("");
		
		if(user_email != null) {
			for(int i = 1; i < user_email.length(); i++) {
				
				if(user_email.charAt(i) == '@' || user_email.charAt(i) == '.') {
					i++; 
					continue;
				}
				
				builder.setCharAt(i, '*');
			}
			result = builder.toString();
		}
		
		return result;
		
	}
	
	@Override
	public int findPwAction(Users users) throws Exception {
		
		int result = 0;
		users = dao.findPwAction(users);
		
		Random rd = new Random();
		StringBuffer buf = new StringBuffer();
		
		if( users == null ) return -1;
		
		for(int i=0;i<7;i++){
		    if(rd.nextBoolean()){
		        buf.append((char)((int)(rd.nextInt(26))+97));
		    }
		    else{
		        buf.append((rd.nextInt(10))); 
		    }
		    users.setUser_pw(buf.toString());
		}
		
		dao.resetpw(users); // 보낸 pw mapper에 update
		
		// users.setUser_pw(user_pw);
		
		String from = "zerogod0703@gmail.com";
		String to	= users.getUser_email();
		String subject = "임시비밀번호 메일";
		String content = "다음 비밀번호를 입력하세요. <br> <h2>" + users.getUser_pw() + "</h2>";
		
		// 환경설정 맞추기
		Properties p = new Properties();
		
		p.put("mail.smtp.user", from); // 환경설정 from으로
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "587");
		p.put("mail.smtp.socketFactory.fallback", "false");
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		p.put("mail.smtp.protocols", "TLSv1.2");
		
		try {
		
			Authenticator auth = new Mail(); // 로그인
			Session s = Session.getInstance(p, auth); // 세션 받아옴
			s.setDebug(true); // 디버깅
			
			MimeMessage msg = new MimeMessage(s); // 세션을 이용해 환경 맞추기
			
			//Address로 받아오기
			Address fromAddr = new InternetAddress(from);
			Address toAddr	= new InternetAddress(to);
			
			//Address로 받아온 거 msg에 입력
			msg.setSubject(subject);
			msg.setRecipient(Message.RecipientType.TO, toAddr);
			msg.setFrom(fromAddr);
			msg.setContent(content, "text/html; charset=UTF-8");
			
			Transport.send(msg); // 모두 작성 후 보냄
			
		} catch(Exception e) {
			e.printStackTrace();
			result = -1;
		}
		 
		return result;
	}

	
	// 로그인 처리
	// parameter : user_name
	// return : {
	//			Users 객체 : 일치
	//			null : 불일치
	//			}
	@Override
	public Users loginAction(Users users) throws Exception {

		return dao.loginAction(users);
	}










	


}
