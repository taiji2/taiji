package com.steins.dao;

import com.steins.BaseTest;
import com.steins.entity.Match;
import com.steins.entity.TeamMember;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserApplyDaoTest extends BaseTest {
	@Autowired
	private UserApplyDao userApplyDao;
	@Test
	public void getMemberInfoByIdNum(){
		String name =userApplyDao.getMemberInfoByIdNum("513901199810290011");
		System.out.println(name);
	}
	@Test
	public void getAllMatchCount(){
		int count=userApplyDao.getAllMatchCount();
		System.out.println(count);
	}
	@Test
	public void getPageMatch(){
		List<Match> matchList=new ArrayList<>();
		Map<String,Object> data=new HashMap<>();
		data.put("startIndex",0);
		data.put("pageSize",5);
		matchList=userApplyDao.getPageMatch(data);
		for (Match match:matchList){
			System.out.println(match);
		}
	}
	@Test
	public void getTeamMember(){
		List<TeamMember> list=new ArrayList<>();
		list=userApplyDao.getTeamMember(1);
		for (TeamMember teamMember:list){
			System.out.println(teamMember);
			
		}
	}

}