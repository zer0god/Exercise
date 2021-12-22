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

@Service //�����ϴ� ���� ����
public class UsersServiceImpl implements UsersService {
	
	@Inject
	UsersDAO dao;
	
	// �̸��� �ߺ�üũ ó��
	// parameter : user_email
	// return : {
	//			0 : ��밡��
	//			1 : �ߺ�
	//			}
	@Override
	public int emailCheck(String user_email) throws Exception {
		
		int result = 0;
		if(dao.emailCheck(user_email) != null) result = 1;
		return result;
		
	}
	
	// �г��� �ߺ�üũ ó��
	// parameter : user_name
	// return : {
	//			0 : ��밡��
	//			1 : �ߺ�
	//			}
	@Override
	public int nameCheck(String user_name) throws Exception {
		
		int result = 0;
		if(dao.nameCheck(user_name) != null) result = 1;
		return result;
		
	}
	
	// ȸ������ ó��
	// parameter : user_email
	@Override
	public void joinAction(Users users) throws Exception {
		dao.join(users);
	}
	
	// �̸��� ã��
	// parameter : user_name
	// return : {
	//			0 : ��ġ
	//			1 : ����ġ
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
		
		dao.resetpw(users); // ���� pw mapper�� update
		
		// users.setUser_pw(user_pw);
		
		String from = "zerogod0703@gmail.com";
		String to	= users.getUser_email();
		String subject = "�ӽú�й�ȣ ����";
		String content = "���� ��й�ȣ�� �Է��ϼ���. <br> <h2>" + users.getUser_pw() + "</h2>";
		
		// ȯ�漳�� ���߱�
		Properties p = new Properties();
		
		p.put("mail.smtp.user", from); // ȯ�漳�� from����
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
		
			Authenticator auth = new Mail(); // �α���
			Session s = Session.getInstance(p, auth); // ���� �޾ƿ�
			s.setDebug(true); // �����
			
			MimeMessage msg = new MimeMessage(s); // ������ �̿��� ȯ�� ���߱�
			
			//Address�� �޾ƿ���
			Address fromAddr = new InternetAddress(from);
			Address toAddr	= new InternetAddress(to);
			
			//Address�� �޾ƿ� �� msg�� �Է�
			msg.setSubject(subject);
			msg.setRecipient(Message.RecipientType.TO, toAddr);
			msg.setFrom(fromAddr);
			msg.setContent(content, "text/html; charset=UTF-8");
			
			Transport.send(msg); // ��� �ۼ� �� ����
			
		} catch(Exception e) {
			e.printStackTrace();
			result = -1;
		}
		 
		return result;
	}

	
	// �α��� ó��
	// parameter : user_name
	// return : {
	//			Users ��ü : ��ġ
	//			null : ����ġ
	//			}
	@Override
	public Users loginAction(Users users) throws Exception {

		return dao.loginAction(users);
	}










	


}
