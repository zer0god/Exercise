package com.exercise.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.exercise.dao.DaysDAO;
import com.exercise.vo.Days;
import com.exercise.vo.Part_Data;
import com.exercise.vo.Part_Sporting;
import com.exercise.vo.Users;

@Service
public class DaysServiceImpl implements DaysService {
	
	@Inject
	DaysDAO dao;
	
	// days_id
	@Override
	public String days(Users users, String days_days) throws Exception {
		
		// users에 있는 email을 가져와서 email 저장
		String email = users.getUser_email();
		
		// days_id 조합
		String days_id = email + "_" + days_days;
		
		Days days = new Days(days_id, days_days, email);
		
		// days를 dao에 insert
		dao.days(days);
		
		// days_id를 controller에 보냄
		return days_id;
		
	}

	@Override
	public List<Part_Sporting> part_sporting(Part_Sporting part_sporting) throws Exception {
		
		// days에 있는 days_id를 가져와서 days_id에 저장
		// String days_id = part_sporting.getDays_id();
		
		// part_sporting_id 조합
		String part_sporting_id = part_sporting.getDays_id() + "_" + part_sporting.getPart_sporting();
		
		part_sporting.setPart_sporting_id(part_sporting_id);
		
		// part_sporting을 dao에 insert
		dao.part_sporting(part_sporting);
		
		List<Part_Sporting> list = dao.getPart_SportingList(part_sporting_id);
		
		return list;
	}

	@Override
	public List<Part_Data> part_data(Part_Data part_data) throws Exception {
		
		// part_data안에 두개의 id 들어있음
		
		// Part_Sporting에 있는 part_sporting_id를 가져와서 part_sporting_id에 저장
		// String part_sporting_id = part_sporting.getPart_sporting_id();
		// part에 있는 part_id를 가져와서 part_id에 저장
		// String part_id = part.getPart_id();
		
		// part_data_id 조합
		String part_data_id = part_data.getPart_sporting_id() + "_" + part_data.getPart_id();
		
		part_data.setPart_data_id(part_data_id);
		
		// part_data를 dao에 insert
		dao.part_data(part_data);
		
		List<Part_Data> list = dao.getPart_DataList(part_data_id);
		
		return list;
		
	}

	@Override
	public Map<String, List<Part_Sporting>> getDateData(String date, String user_email) throws Exception {
		
		Map<String, List<Part_Sporting>> map = new HashMap<String, List<Part_Sporting>>();
		// 작업 할 map 만들기
		
		Days days = new Days(); // Days 
		days.setDays(date);		// Days의 Days에 date 입력
		days.setUser_email(user_email); // Days의 User_email에 user_email 입력
		
		List<Days> list = dao.getDateData(days);
		
		return map;
	}

}
