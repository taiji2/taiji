package com.steins.service;

import com.steins.dto.GameApplyExecution;
import com.steins.dto.TeamMemberExecution;
import com.steins.entity.Event;
import com.steins.entity.GameApply;
import com.steins.entity.TeamMember;
import com.steins.entity.Match;


import java.lang.reflect.Member;
import java.util.List;

public interface UserApplyService {
	public static final String USERAPPLYKEY="userapplylist";
	//报名表信息的插入及获取=============================================================================
	
	//	根据比赛id从match表选择比赛名字
	
	String getMatchName(int matchId);
	
	//将报名表的头信息传入game_apply
	
	GameApplyExecution insertApplyHead(GameApply gameApply);
	
	//将项目名字的数据从项目库event中选择出来
	
	List<Event> getAllEvents(int matchId);
	
	//获得队伍名字
	int  getTeamName(String teamName);
	
	//将队员以及队员的报名信息插入team_member表
	
	TeamMemberExecution insertTeamMember(List<TeamMember> members);
	
	
	
	
	
	//查看比赛页面===========================================================
	//列出所有比赛的目录
	List<Match> getAllMatch();
	
	//查看比赛详情
	//根据查看比赛详情基本全部字段
	Match getMatchInfo (int matchId);
	
	//列出已经报名过的比赛目录
	//获取已经参加过比赛的数目=================================================
	Integer getApplyedMatchCount(String idNumber);
	List<Match> getApplyedMatch(String idNumber,int pageNum,int pageSize);
	
	//报名过的比赛还可以点击查看自己的队伍详情
	// 获取申请表的id
	int getGameApplyId(String idNumber,int matchId);
	
	//获得领队身份证号

	
	//
	String getLeaderIdNum(String idNumber, int matchId);
	
	//获取本人身份是否为领队
	//int myIdentity(int idNumber);
	
	int myIdentity(String idNumber, int gameApplyId);
	
	//获取所有队员信息
	List<TeamMember> getAllMyGroup(String idNumber,int matchId);
	
//	<!--根据身份证号查看这个人是否是会员以及获得一些信息-->
	String getMemberInfoByIdNum(String idNumber);
//	获取某一页的Match
	List<Match> getPageMatch(int pageNum,int PageSize);
//	//	获取某一页的已参加的Match
//	List<Match> getPageApplyedMatch(String idNumber,int pageNum,int PageSize);
	//获取所有比赛的数量
	Integer getAllMatchCount();
	
	
	//获取所有队伍+++++++++++++++++++++++++
	List<GameApply> getAllTeams(int matchId,int pageNum,int pageSize);
	//获取所有队伍的数量
	Integer getAllTeamsCount(int matchId);
	
	//管理员获取队伍的具体信息
	List<TeamMember> getTeamMember(int gameApplyId);
	
}
