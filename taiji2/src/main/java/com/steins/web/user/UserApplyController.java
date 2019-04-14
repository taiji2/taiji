package com.steins.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steins.dto.GameApplyExecution;
import com.steins.dto.TeamMemberExecution;
import com.steins.entity.Event;
import com.steins.entity.GameApply;
import com.steins.entity.Match;
import com.steins.entity.TeamMember;
import com.steins.service.UserApplyService;
import com.steins.util.HttpServletRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sunny
 */
@Controller
@RequestMapping("/user")
public class UserApplyController {
	Logger logger = LoggerFactory.getLogger(UserApplyController.class);
	@Autowired
	private UserApplyService userApplyService;
	
	@ResponseBody
	@RequestMapping(value = "getMatchName", method = RequestMethod.GET)
	public Map<String, Object> getMatchName(HttpServletRequest request) {
//		String str = HttpServletRequestUtil.getString(request, "getMatchName");
//		ObjectMapper mapper = new ObjectMapper();
//		logger.info("==start==");
//		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String matchName;
		int matchId= Integer.parseInt(request.getParameter("matchId"));
		try {
			matchName = userApplyService.getMatchName(matchId);
			modelMap.put("rows", matchName);
			modelMap.put("sucess", true);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			modelMap.put("errMsg", ex.toString());
		}
//		logger.error("test error!");
		
		
		return modelMap;
		
	}
	@ResponseBody
	@RequestMapping(value = "insertApplyHead", method = RequestMethod.GET)
	public Map<String, Object> insertApplyHead(HttpServletRequest request) {
		String str = HttpServletRequestUtil.getString(request, "insertApplyHead");
		ObjectMapper mapper = new ObjectMapper();
		logger.info("==start==");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		GameApplyExecution flag ;
		GameApply gameApply= (GameApply) request.getAttribute("insertApplyHead");
		try {
			flag = userApplyService.insertApplyHead(gameApply);
			modelMap.put("rows", flag);
			modelMap.put("sucess", true);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			modelMap.put("errMsg", ex.toString());
		}
		logger.error("test error!");
		
		
		return modelMap;
		
	}
	@ResponseBody
	@RequestMapping(value = "getAllEvents", method = RequestMethod.GET)
	public Map<String, Object> getAllEvents(HttpServletRequest request) {
		String str = HttpServletRequestUtil.getString(request, "getAllEvents");
		ObjectMapper mapper = new ObjectMapper();
		logger.info("==start==");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Event> list = new ArrayList<>();
		try {
			int matchId= Integer.parseInt(request.getParameter("matchId"));
			list = userApplyService.getAllEvents(matchId);
			modelMap.put("rows", list);
			modelMap.put("sucess", true);
			modelMap.put("total", list.size());
			
		} catch (Exception ex) {
			ex.printStackTrace();
			modelMap.put("errMsg", ex.toString());
		}
		logger.error("test error!");
		
		
		return modelMap;
	}
	@ResponseBody
	@RequestMapping(value = "insertTeamMember", method = RequestMethod.GET)
	public Map<String, Object> insertTeamMember(HttpServletRequest request) {
		String str = HttpServletRequestUtil.getString(request, "insertTeamMember");
		ObjectMapper mapper = new ObjectMapper();
		logger.info("==start==");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		TeamMemberExecution flag ;
		List<TeamMember> list = new ArrayList<>();
		list = (List<TeamMember>) request.getAttribute("insertTeamMember");
		try {
			flag = userApplyService.insertTeamMember(list);
			modelMap.put("rows", flag);
			modelMap.put("sucess", true);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			modelMap.put("errMsg", ex.toString());
		}
		logger.error("test error!");
		return modelMap;
	}
	//比赛页面====================================================
	@ResponseBody
	@RequestMapping(value = "getAllMatch", method = RequestMethod.GET)
	public Map<String,Object> getAllMatch (HttpServletRequest request){
//		当前页是什么
		int pageNum= Integer.parseInt(request.getParameter("pageNum"));
		int pageSize=10;
		int count=userApplyService.getAllMatchCount();
		List<Match> list=new ArrayList<>();
		Map<String ,Object> map=new HashMap<>();
		try {
			list=userApplyService.getPageMatch(pageNum,pageSize);
			map.put("count",count);
			map.put("rows",list);
			map.put("success",true);
		} catch (Exception ex) {
			ex.printStackTrace();
			map.put("errMsg", ex.toString());
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "getMatchInfo",method = RequestMethod.GET)
	public Map<String , Object> getMatchInfo(HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		int matchId= Integer.parseInt(request.getParameter("matchId"));
		Match match=new Match();
		try {
			match=userApplyService.getMatchInfo(matchId);
			map.put("rows",match);
			map.put("success",true);
		}catch (Exception ex){
			ex.printStackTrace();
			map.put("srrMsg",ex.toString());
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value ="getApplyedMatch", method =RequestMethod.GET)
	public Map<String, Object> getApplyedMatch(HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		String idNumber=  request.getParameter("idNumber");
		int  pageNum= Integer.valueOf(request.getParameter("pageNum"));
		int  pageSize=10;
		List<Match> matchList=new ArrayList<>();
		try {
			int count=userApplyService.getApplyedMatchCount(idNumber);
			matchList=userApplyService.getApplyedMatch(idNumber,pageNum,pageSize);
			map.put("count",count);
			map.put("rows",matchList);
			map.put("susses",true);
		}catch (Exception ex){
			ex.printStackTrace();
			map.put("errMsg",ex.toString());
		}
		return map;
		
	}
	@ResponseBody
	@RequestMapping(value = "getLeaderIdNum",method = RequestMethod.GET)
	public Map<String,Object> getLeaderIdNum(HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		String idNumber=  request.getParameter("idNumber");
		int matchId= (int) request.getAttribute("matchId");
		String leaderIdNumber="";
		try {
			leaderIdNumber=userApplyService.getLeaderIdNum(idNumber,matchId);
			map.put("rows",leaderIdNumber);
			map.put("success",true);
		}catch (Exception ex){
			ex.printStackTrace();
			map.put("errMsg",ex.toString());
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "getAllMyGroup",method = RequestMethod.GET)
	public Map<String,Object> getAllMyGroup(HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		String idNumber=  request.getParameter("idNumber");
		int matchId= (int) request.getAttribute("matchId");
		List<TeamMember> memberList=new ArrayList<>();
		try {
			memberList=userApplyService.getAllMyGroup(idNumber,matchId);
			map.put("rows",memberList);
			map.put("success",true);
		}catch (Exception ex){
			ex.printStackTrace();
			map.put("errMsg",ex.toString());
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "getAllTeams",method = RequestMethod.GET)
	public Map<String,Object> getAllTeams(HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		int  pageNum= Integer.valueOf(request.getParameter("pageNum"));
		int  pageSize= 10;
		int matchId= Integer.valueOf(request.getParameter("matchId"));
		List<GameApply> gameApplyList=new ArrayList<>();
		try {
			gameApplyList=userApplyService.getAllTeams(matchId,pageNum,pageSize);
			int count=userApplyService.getAllTeamsCount(matchId);
			map.put("count",count);
			map.put("rows",gameApplyList);
			map.put("success",true);
		}catch (Exception ex){
			ex.printStackTrace();
			map.put("errMsg",ex.toString());
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "getTeamMember",method = RequestMethod.GET)
	public Map<String,Object> getTeamMember(HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		int gameApplyId= Integer.valueOf(request.getParameter("gameApplyId"));
		List<TeamMember> memberList=new ArrayList<>();
		try {
			memberList=userApplyService.getTeamMember(gameApplyId);
			map.put("rows",memberList);
			map.put("success",true);
		}catch (Exception ex){
			ex.printStackTrace();
			map.put("errMsg",ex.toString());
		}
		return map;
	}
	
}
