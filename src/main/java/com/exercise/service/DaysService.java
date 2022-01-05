package com.exercise.service;

import java.util.List;
import java.util.Map;

import com.exercise.vo.Part_Data;
import com.exercise.vo.Part_Sporting;
import com.exercise.vo.Users;

public interface DaysService {
	
	public String days(Users users, String days_days) throws Exception;
	public List<Part_Sporting> part_sporting(Part_Sporting part_sporting_) throws Exception;
	public List<Part_Data> part_data(Part_Data part_data) throws Exception;
	public Map<String, List<Part_Sporting>> getDateData(String date, String user_email) throws Exception;
	// controller에서 date 받아옴. service에서 Map<String, List<Part_Sporting>> 작업.
	
}
