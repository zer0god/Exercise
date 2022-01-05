package com.exercise.dao;

import java.util.List;

import com.exercise.vo.Days;
import com.exercise.vo.Part_Data;
import com.exercise.vo.Part_Sporting;

public interface DaysDAO {
	
	public void days(Days days) throws Exception; // 반환값 필요없음(비교하는 거 아님)
	public void part_sporting(Part_Sporting part_sporting) throws Exception;
	public void part_data(Part_Data part_data) throws Exception;
	public List<Part_Sporting> getPart_SportingList(String days_id) throws Exception;
	public List<Part_Data> getPart_DataList(String part_sporting_id) throws Exception;
	public List<Days> getDateData(Days days) throws Exception;
	
}
