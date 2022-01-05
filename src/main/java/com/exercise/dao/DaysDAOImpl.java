package com.exercise.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.exercise.vo.Days;
import com.exercise.vo.Part_Data;
import com.exercise.vo.Part_Sporting;

public class DaysDAOImpl implements DaysDAO {
	
	@Inject
	SqlSession sqlSession;
	
	final String SESSION = "com.exercise.mappers.exercise";

	@Override
	public void days(Days days) throws Exception {
		sqlSession.insert(SESSION + ".days", days);
	}

	@Override
	public void part_sporting(Part_Sporting part_sporting) throws Exception {
		sqlSession.insert(SESSION + ".part_sporting", part_sporting);
	}

	@Override
	public void part_data(Part_Data part_data) throws Exception {
		sqlSession.insert(SESSION + ".part_data", part_data);
	}

	@Override
	public List<Part_Sporting> getPart_SportingList(String days_id) throws Exception {
		return sqlSession.selectList(SESSION + ".getPart_SportingList", days_id);
	}

	@Override
	public List<Part_Data> getPart_DataList(String part_sporting_id) throws Exception {
		return sqlSession.selectList(SESSION +".getPart_Data", part_sporting_id);
	}

	@Override
	public List<Days> getDateData(Days days) throws Exception {
		return sqlSession.selectList(SESSION +".getDateData", days);
	}
	

}
