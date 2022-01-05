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
		
		// users�� �ִ� email�� �����ͼ� email ����
		String email = users.getUser_email();
		
		// days_id ����
		String days_id = email + "_" + days_days;
		
		Days days = new Days(days_id, days_days, email);
		
		// days�� dao�� insert
		dao.days(days);
		
		// days_id�� controller�� ����
		return days_id;
		
	}

	@Override
	public List<Part_Sporting> part_sporting(Part_Sporting part_sporting) throws Exception {
		
		// days�� �ִ� days_id�� �����ͼ� days_id�� ����
		// String days_id = part_sporting.getDays_id();
		
		// part_sporting_id ����
		String part_sporting_id = part_sporting.getDays_id() + "_" + part_sporting.getPart_sporting();
		
		part_sporting.setPart_sporting_id(part_sporting_id);
		
		// part_sporting�� dao�� insert
		dao.part_sporting(part_sporting);
		
		List<Part_Sporting> list = dao.getPart_SportingList(part_sporting_id);
		
		return list;
	}

	@Override
	public List<Part_Data> part_data(Part_Data part_data) throws Exception {
		
		// part_data�ȿ� �ΰ��� id �������
		
		// Part_Sporting�� �ִ� part_sporting_id�� �����ͼ� part_sporting_id�� ����
		// String part_sporting_id = part_sporting.getPart_sporting_id();
		// part�� �ִ� part_id�� �����ͼ� part_id�� ����
		// String part_id = part.getPart_id();
		
		// part_data_id ����
		String part_data_id = part_data.getPart_sporting_id() + "_" + part_data.getPart_id();
		
		part_data.setPart_data_id(part_data_id);
		
		// part_data�� dao�� insert
		dao.part_data(part_data);
		
		List<Part_Data> list = dao.getPart_DataList(part_data_id);
		
		return list;
		
	}

	@Override
	public Map<String, List<Part_Sporting>> getDateData(String date, String user_email) throws Exception {
		
		Map<String, List<Part_Sporting>> map = new HashMap<String, List<Part_Sporting>>();
		// �۾� �� map �����
		
		Days days = new Days(); // Days 
		days.setDays(date);		// Days�� Days�� date �Է�
		days.setUser_email(user_email); // Days�� User_email�� user_email �Է�
		
		List<Days> list = dao.getDateData(days);
		
		return map;
	}

}
