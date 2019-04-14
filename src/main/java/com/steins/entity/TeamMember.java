package com.steins.entity;

import java.util.List;

public class TeamMember {
	private int teamMemberId;
	//队员名字
	private String memberName;
	//队员身份证
	private Integer idNumber;
	//队员性别
	private Integer sex;
	//队员组别，按年龄
	private String memberGroup;
	//项目表的标识id
	private String eventId;
	//对练标识。谁和谁对练
	private String duilianFlag;
	//是否需要提供食物
	private Integer isNeedFood;
	//是否需要住处
	private Integer isNeedSleep;
	//是否参加对练
	private Integer isDuilian;
	//是否参加集体项目
	private Integer isTeam;
	//参加的对练集体名称
	private String eventTeamName;
	//参加的对练项目名称
	private String eventDuilianName;
	
	public List<Event> getEventList() {
		return eventList;
	}
	
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	
	private List<Event> eventList;
	
	@Override
	public String toString() {
		return "TeamMember{" +
				"teamMemberId=" + teamMemberId +
				", memberName='" + memberName + '\'' +
				", idNumber=" + idNumber +
				", sex=" + sex +
				", memberGroup='" + memberGroup + '\'' +
				", eventId='" + eventId + '\'' +
				", duilianFlag='" + duilianFlag + '\'' +
				", isNeedFood=" + isNeedFood +
				", isNeedSleep=" + isNeedSleep +
				", isDuilian=" + isDuilian +
				", isTeam=" + isTeam +
				", eventTeamName='" + eventTeamName + '\'' +
				", eventDuilianName='" + eventDuilianName + '\'' +
				", eventList=" + eventList +
				'}';
	}
	
	public int getTeamMemberId() {
		return teamMemberId;
	}
	
	public void setTeamMemberId(int teamMemberId) {
		this.teamMemberId = teamMemberId;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public Integer getIdNumber() {
		return idNumber;
	}
	
	public void setIdNumber(Integer idNumber) {
		this.idNumber = idNumber;
	}
	
	public Integer getSex() {
		return sex;
	}
	
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public String getMemberGroup() {
		return memberGroup;
	}
	
	public void setMemberGroup(String memberGroup) {
		this.memberGroup = memberGroup;
	}
	
	public String getEventId() {
		return eventId;
	}
	
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	public String getDuilianFlag() {
		return duilianFlag;
	}
	
	public void setDuilianFlag(String duilianFlag) {
		this.duilianFlag = duilianFlag;
	}
	
	public Integer getIsNeedFood() {
		return isNeedFood;
	}
	
	public void setIsNeedFood(Integer isNeedFood) {
		this.isNeedFood = isNeedFood;
	}
	
	public Integer getIsNeedSleep() {
		return isNeedSleep;
	}
	
	public void setIsNeedSleep(Integer isNeedSleep) {
		this.isNeedSleep = isNeedSleep;
	}
	
	public Integer getIsDuilian() {
		return isDuilian;
	}
	
	public void setIsDuilian(Integer isDuilian) {
		this.isDuilian = isDuilian;
	}
	
	public Integer getIsTeam() {
		return isTeam;
	}
	
	public void setIsTeam(Integer isTeam) {
		this.isTeam = isTeam;
	}
	
	public String getEventTeamName() {
		return eventTeamName;
	}
	
	public void setEventTeamName(String eventTeamName) {
		this.eventTeamName = eventTeamName;
	}
	
	public String getEventDuilianName() {
		return eventDuilianName;
	}
	
	public void setEventDuilianName(String eventDuilianName) {
		this.eventDuilianName = eventDuilianName;
	}
}
