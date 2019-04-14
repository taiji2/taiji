package com.steins.service.impl;

import com.steins.cache.JedisUtil;
import com.steins.dao.UserApplyDao;
import com.steins.dto.GameApplyExecution;
import com.steins.dto.TeamMemberExecution;
import com.steins.entity.*;
import com.steins.enums.GameApplyEnum;
import com.steins.enums.TeamMemberEnum;
import com.steins.exceptions.UserApplyOperationException;
import com.steins.service.UserApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sunny
 */
@Service
public class UserApplyServiceImpl implements UserApplyService {
	
	@Autowired
	private UserApplyDao userApplyDao;
	@Autowired
	private JedisUtil.Keys jedisKeys;
	@Autowired
	private JedisUtil.Strings jedisStrings;
	private static Logger logger = LoggerFactory.getLogger(UserApplyServiceImpl.class);
	
	@Override
	@Transactional
	public String getMatchName(int matchId) {
		String matchName = userApplyDao.getMatchName(matchId);
		return matchName;
	}
	
	@Override
	@Transactional
	public GameApplyExecution insertApplyHead(GameApply gameApply) {
		//验证是否有重名
		String teamName = gameApply.getTeamName();
		String flag = userApplyDao.getTeamName(teamName);
		
		if (!(flag != null) && gameApply.getTeamName() != null && !"".equals(gameApply.getTeamName())) {
			// 设置默认值
			//userApply.setTeamName(String.valueOf(new Date()));
			
			
			try {
				int effectedNum = userApplyDao.insertApplyHead(gameApply);
				if (effectedNum > 0) {
					
					return new GameApplyExecution(GameApplyEnum.SUCCESS, gameApply);
				} else {
					return new GameApplyExecution(GameApplyEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new UserApplyOperationException("添加报名表失败:" + e.toString());
			}
		} else {
			return new GameApplyExecution(GameApplyEnum.EMPTY);
		}
	}
	
	@Override
	@Transactional
	public List<Event> getAllEvents(int matchId) {
		List<Event> list = new ArrayList<>();
		list = userApplyDao.getAllEvents(matchId);
		return list;
//		// 定义redis的key
//		//String key = USERAPPLYKEY;
//		// 定义接收对象
//		List<UserApply> userApplyList = null;
//		// 定义jackson数据转换操作类
//		//ObjectMapper mapper = new ObjectMapper();
//		// 判断key是否存在
//		if (!jedisKeys.exists(key)) {
//			// 若不存在，则从数据库里面取出相应数据
//			userApplyList = userApplyDao.getAllEvents();
//			// 将相关的实体类集合转换成string,存入redis里面对应的key中
//			String jsonString;
//			try {
//				jsonString = mapper.writeValueAsString(userApplyList);
//			} catch (JsonProcessingException e) {
//				e.printStackTrace();
//				logger.error(e.getMessage());
//				throw new UserApplyOperationException(e.getMessage());
//			}
//			jedisStrings.set(key, jsonString);
//		} else {
//			// 若存在，则直接从redis里面取出相应数据
//			String jsonString = jedisStrings.get(key);
//			// 指定要将string转换成的集合类型
//			JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, UserApply.class);
//			try {
//				// 将相关key对应的value里的的string转换成对象的实体类集合
//				userApplyList = mapper.readValue(jsonString, javaType);
//			} catch (JsonParseException e) {
//				e.printStackTrace();
//				logger.error(e.getMessage());
//				throw new UserApplyOperationException(e.getMessage());
//			} catch (JsonMappingException e) {
//				e.printStackTrace();
//				logger.error(e.getMessage());
//				throw new UserApplyOperationException(e.getMessage());
//			} catch (IOException e) {
//				e.printStackTrace();
//				logger.error(e.getMessage());
//				throw new UserApplyOperationException(e.getMessage());
//			}
//		}
//		return userApplyList;
	}
	
	
	//
	@Override
	public int getTeamName(String teamName) {
		return 0;
	}
	
	@Override
	public TeamMemberExecution insertTeamMember(List<TeamMember> members) {
		
		
		if (!(members.isEmpty())) {
			try {
				int effectedNum = userApplyDao.insertTeamMember(members);
				if (effectedNum > 0) {
					
					return new TeamMemberExecution(TeamMemberEnum.SUCCESS, members);
				} else {
					return new TeamMemberExecution(TeamMemberEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new UserApplyOperationException("添加报名表失败:" + e.toString());
			}
		} else {
			return new TeamMemberExecution(TeamMemberEnum.EMPTY);
		}
	}
	
	//比赛页面=========================================================
	@Override
	public List<Match> getAllMatch() {
//		int count=userApplyDao.getAllMatchCount();
//		int startIndex=pageNum*pageSize-pageSize;
		List<Match> matchList = new ArrayList<>();
		
		
		matchList = userApplyDao.getAllMatch();
		return matchList;
	}
	
	@Override
	public Match getMatchInfo(int matchId) {
		Match match = new Match();
		match = userApplyDao.getMatchInfo(matchId);
		return match;
	}
	
	//
//	@Override
//	public List<Integer> getMatchId(String idNumber) {
//		return null;
//	}
	//获取已经参加过比赛的数目=================================================
	@Override
	public 	Integer getApplyedMatchCount(String idNumber){
		int count=userApplyDao.getApplyedMatchCount(idNumber);
		return count;
	}
	@Override
	public List<Match> getApplyedMatch(String idNumber, int pageNum, int pageSize){
		Map<String,Object> map=new HashMap<>();
		int count =userApplyDao.getApplyedMatchCount(idNumber);
		Page page = new Page(pageNum, pageSize, count);
		int startIndex=pageNum * pageSize - pageSize;
		map.put("idNumber",idNumber);
		map.put("startIndex",startIndex);
		map.put("pageSize",pageSize);
		
		List<Match> list = new ArrayList<>();
		list = userApplyDao.getApplyedMatch(map);
		page.setList(list);
		List<Match> matchList=new ArrayList<>();
		matchList=page.getList();
		return matchList;
	}
	
	//
	@Override
	public int getGameApplyId(String idNumber, int matchId) {
		return 0;
	}
	
	//
	@Override
	public String getLeaderIdNum(String idNumber, int matchId) {
		//获得gameApplyId
		int gameApplyId = userApplyDao.getGameApplyId(idNumber, matchId);
		String leaderIdNum = userApplyDao.getLeaderIdNum(gameApplyId);
		return leaderIdNum;
	}
	
	@Override
	public int myIdentity(String idNumber, int gameApplyId) {
		//获得gameApplyId
		
		return 0;
	}
	
	@Override
	public List<TeamMember> getAllMyGroup(String idNumber, int matchId) {
		//获得gameApplyId
		int gameApplyId = userApplyDao.getGameApplyId(idNumber, matchId);
		List<TeamMember> memberList = new ArrayList<>();
		memberList = userApplyDao.getAllMyGroup(gameApplyId, matchId);
		return memberList;
	}
	
	//查看这个人是否是会员并返回姓名
	@Override
	public String getMemberInfoByIdNum(String idNumber) {
		
		try {
			String name = userApplyDao.getMemberInfoByIdNum(idNumber);
			
			if (("").equals(name) || null == name) {
				return "查无此人";
			} else {
				return name;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		
	}
	//获取所有比赛的数量
	@Override
	public Integer getAllMatchCount(){
		int count=userApplyDao.getAllMatchCount();
		return count;
	}
	
	@Override
	public List<Match> getPageMatch(int pageNum, int pageSize) {
		int count = userApplyDao.getAllMatchCount();
		Page page = new Page(pageNum, pageSize, count);
		Map<String, Object> map = new HashMap<>();
		
		map.put("startIndex", pageNum * pageSize - pageSize);
		map.put("pageSize", pageSize);
		List<Match> list = new ArrayList<>();
		list = userApplyDao.getPageMatch(map);
		page.setList(list);
		List<Match> matchList=new ArrayList<>();
		matchList=page.getList();
		return matchList;
	}
	
	//获取已报名队伍+++++++++++++++++++++++++++
	@Override
	public List<GameApply> getAllTeams(int matchId,int pageNum,int pageSize){
		int count =userApplyDao.getAllMatchCount();
		Page page = new Page(pageNum, pageSize, count);
		Map<String, Object> map = new HashMap<>();
		map.put("matchId",matchId);
		map.put("startIndex", pageNum * pageSize - pageSize);
		map.put("pageSize", pageSize);
		List<GameApply> list = new ArrayList<>();
		list = userApplyDao.getAllTeams(map);
		page.setList(list);
		List<GameApply> gameApplyList=new ArrayList<>();
		gameApplyList=page.getList();
		return gameApplyList;
	}
	@Override
	public Integer getAllTeamsCount(int matchId){
		int count=userApplyDao.getAllTeamsCount(matchId);
		return count;
	}
	@Override
	public List<TeamMember> getTeamMember(int gameApplyId){
		List<TeamMember> list=new ArrayList<>();
		list=userApplyDao.getTeamMember(gameApplyId);
		return list;
	}
}
