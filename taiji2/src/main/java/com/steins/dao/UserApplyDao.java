package com.steins.dao;

import com.steins.entity.Event;
import com.steins.entity.GameApply;
import com.steins.entity.Match;
import com.steins.entity.TeamMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Sunny
 */
public interface UserApplyDao {
	//报名表信息的插入及获取=============================================================================
	
	//	根据比赛id从match表选择比赛名字
	
	String getMatchName(int matchId);
	
	//将报名表的头信息传入game_apply
	
	int insertApplyHead(GameApply gameApply);
	
	//将项目名字的数据从项目库event中选择出来
	
	List<Event> getAllEvents(int matchId);
	
	//获得队伍名字
	String getTeamName(String teamName);
	
	//将队员以及队员的报名信息插入team_member表
	
	int insertTeamMember(@Param("list") List<TeamMember> members);
	
	
	
	
	
	//查看比赛页面===========================================================
	//列出所有比赛的目录
	List<Match> getAllMatch();
	
	//查看比赛详情
	//根据查看比赛详情基本全部字段
	Match getMatchInfo (int matchId);
	
	//列出已经报名过的比赛目录
	List<Integer> getMatchId(String idNumber);
	//根据已经获得的matchId获得比赛信息
	
	List<Match> getApplyedMatch(int matchId);
	
	//报名过的比赛还可以点击查看自己的队伍详情
	// 获取申请表的id
	int getGameApplyId(String idNumber,int matchId);
	
	//获得领队身份证号
	String getLeaderIdNum(int gameApplyId);
	
	//获取所有队员信息
	List<TeamMember> getAllMyGroup(int gameApplyId,int matchId);
	
	String getMemberInfoByIdNum(String idNumber);
	
	//==================================================
	//获取比赛表中所有比赛的数目
	Integer getAllMatchCount();
	//获取某一页的所有比赛
	List<Match> getPageMatch(Map<String,Object> map);
	
	
	//获取已经参加的比赛的数目
	Integer getPageApplyedMatchCount(String idNumber);
	//	获取某一页的已参加的Match
	List<Match> getPageApplyedMatch(Map<String,Object> map);
	
	//管理员=====================================
	//获取所有报名的队伍的数量
	Integer getAllTeamsCount(int matchId);
	//获取所有报名的队伍
	List<GameApply> getAllTeams(Map<String,Object> map);
	//管理员获取队伍信息
	List<TeamMember> getTeamMember(int gameApplyId);
	
	
	
	//获取已经参加过比赛的数目=================================================
	Integer getApplyedMatchCount(String idNumber);
	List<Match> getApplyedMatch(Map<String,Object> map);
	
}
