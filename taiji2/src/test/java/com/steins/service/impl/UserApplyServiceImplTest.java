package com.steins.service.impl;

import com.steins.BaseTest;
import com.steins.entity.GameApply;
import com.steins.entity.Match;
import com.steins.service.UserApplyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserApplyServiceImplTest extends BaseTest {
	@Autowired
	private UserApplyService userApplyService;
	@Test
	public void getMemberInfoByIdNum(){
		
		String s=userApplyService.getMemberInfoByIdNum("513901199810290011");
		System.out.println(s);
	}
	@Test
	public void getPageMatch(){
		List<Match> list=new ArrayList<>();
		list=userApplyService.getPageMatch(1,10);
		for(Match match:list){
			System.out.println(match);
		}
	}
	@Test
	public void getAllTeams(){
		List<GameApply> list=new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		int matchId=1;
		int pageNum=2;
		int pageSize=2;
		map.put("matchId",matchId);
		map.put("startIndex", pageNum * pageSize - pageSize);
		map.put("pageSize", pageSize);
		list=userApplyService.getAllTeams(1,1,10);
		for (GameApply gameApply:list){
			System.out.println(gameApply);
		}
	}
	@Test
	public void getAllTeamsCount(){
		int count=userApplyService.getAllTeamsCount(1);
		System.out.println(count);
	}
	@Test
	public void getApplyedMatch(){
		List<Match> list=new ArrayList<>();
		list=userApplyService.getApplyedMatch("5433",1,10);
		for (Match match:list){
			System.out.println(match);
		}
	}
	

}