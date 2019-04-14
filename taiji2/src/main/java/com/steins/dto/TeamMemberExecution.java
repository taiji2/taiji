package com.steins.dto;

import com.steins.entity.TeamMember;
import com.steins.enums.TeamMemberEnum;

import java.util.List;

/**
 * @author Sunny
 */
public class TeamMemberExecution {
	// 结果状态
	private int state;
	
	// 状态标识
	private String stateInfo;
	
	// 数量
	private int count;
	
	// 操作的award（增删改商品的时候用）
	private TeamMember teamMember;
	
	// 获取的award列表(查询商品列表的时候用)
	private List<TeamMember> teamMemberList;
	
	public TeamMemberExecution() {
	}
	
	// 失败的构造器
	public TeamMemberExecution(TeamMemberEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}
	
	// 成功的构造器
	public TeamMemberExecution(TeamMemberEnum stateEnum,TeamMember teamMember) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.teamMember = teamMember;
	}
	
	// 成功的构造器
	public TeamMemberExecution(TeamMemberEnum stateEnum, List<TeamMember> teamMemberList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.teamMemberList = teamMemberList;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public String getStateInfo() {
		return stateInfo;
	}
	
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public TeamMember getTeamMember() {
		return teamMember;
	}
	
	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}
	
	public List<TeamMember> getTeamMemberList() {
		return teamMemberList;
	}
	
	public void setTeamMemberList(List<TeamMember> teamMemberList) {
		this.teamMemberList = teamMemberList;
	}
}
