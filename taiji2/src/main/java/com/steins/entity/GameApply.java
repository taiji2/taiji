package com.steins.entity;

import java.util.List;

public class GameApply {
	private List<TeamMember> teamMember;
	//申请表的标识
	private Integer gameApplyId;
	//小队名字
	private String teamName;
	//省
	private String areaProvince;
	//地市州
	private String areaCity;
	//区县
	private String areaCountry;
	//练功点
	private String areaGroup;
	//领队是否兼职
	private Integer leaderFlag;
	//领队名字
	private String leaderName;
	//领队联系方式
	private String leaderNum;
	//领队身份证号码
	private String leaderIdNum;
	//领队性别
	private Integer leaderSex;
	//教练是否兼职
	private Integer coachFlag;
	//教练名字
	private String coachName;
	//教练身份证号
	private String coachIdNum;
	//教练联系方式
	private String coachNum;
	//教练性别
	private Integer coachSex;
	//教练备注
	private String coachRemark;
	//队医是否兼职
	private Integer doctorFlag;
	//队医名字
	private String doctorName;
	//队医联系方式
	private String doctorNum;
	//队医的身份证
	private  String doctorIdNum;
	//队医性别
	private Integer doctorSex;
	//队医标注
	private String doctorRemark;
	//队员表的标识id
	private Integer teamMemberId;
	//	比赛表的标识id
	private int matchId;
	//	男队员总数
	private Integer teamMaleNumber;
	//	女队员总数
	private Integer teamFemaleNumber;
	//队员总人数
	private Integer teamNumber;
	//	队伍性质，地市州
	private String teamType;
	//队伍性质标识
	private Integer teamTypeFlag;
	

	
	//男女运动员总人数
	private Integer athleteNumber;
	
	@Override
	public String toString() {
		return "GameApply{" +
				"teamMember=" + teamMember +
				", gameApplyId=" + gameApplyId +
				", teamName='" + teamName + '\'' +
				", areaProvince='" + areaProvince + '\'' +
				", areaCity='" + areaCity + '\'' +
				", areaCountry='" + areaCountry + '\'' +
				", areaGroup='" + areaGroup + '\'' +
				", leaderFlag=" + leaderFlag +
				", leaderName='" + leaderName + '\'' +
				", leaderNum='" + leaderNum + '\'' +
				", leaderIdNum='" + leaderIdNum + '\'' +
				", leaderSex=" + leaderSex +
				", coachFlag=" + coachFlag +
				", coachName='" + coachName + '\'' +
				", coachIdNum='" + coachIdNum + '\'' +
				", coachNum='" + coachNum + '\'' +
				", coachSex=" + coachSex +
				", coachRemark='" + coachRemark + '\'' +
				", doctorFlag=" + doctorFlag +
				", doctorName='" + doctorName + '\'' +
				", doctorNum='" + doctorNum + '\'' +
				", doctorIdNum='" + doctorIdNum + '\'' +
				", doctorSex=" + doctorSex +
				", doctorRemark='" + doctorRemark + '\'' +
				", teamMemberId=" + teamMemberId +
				", matchId=" + matchId +
				", teamMaleNumber=" + teamMaleNumber +
				", teamFemaleNumber=" + teamFemaleNumber +
				", teamNumber=" + teamNumber +
				", teamType='" + teamType + '\'' +
				", teamTypeFlag=" + teamTypeFlag +
				", athleteNumber=" + athleteNumber +
				'}';
	}
	
	public List<TeamMember> getTeamMember() {
		return teamMember;
	}
	
	public void setTeamMember(List<TeamMember> teamMember) {
		this.teamMember = teamMember;
	}
	
	public Integer getGameApplyId() {
		return gameApplyId;
	}
	
	public void setGameApplyId(Integer gameApplyId) {
		this.gameApplyId = gameApplyId;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getAreaProvince() {
		return areaProvince;
	}
	
	public void setAreaProvince(String areaProvince) {
		this.areaProvince = areaProvince;
	}
	
	public String getAreaCity() {
		return areaCity;
	}
	
	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}
	
	public String getAreaCountry() {
		return areaCountry;
	}
	
	public void setAreaCountry(String areaCountry) {
		this.areaCountry = areaCountry;
	}
	
	public String getAreaGroup() {
		return areaGroup;
	}
	
	public void setAreaGroup(String areaGroup) {
		this.areaGroup = areaGroup;
	}
	
	public Integer getLeaderFlag() {
		return leaderFlag;
	}
	
	public void setLeaderFlag(Integer leaderFlag) {
		this.leaderFlag = leaderFlag;
	}
	
	public String getLeaderName() {
		return leaderName;
	}
	
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	
	public String getLeaderNum() {
		return leaderNum;
	}
	
	public void setLeaderNum(String leaderNum) {
		this.leaderNum = leaderNum;
	}
	
	public String getLeaderIdNum() {
		return leaderIdNum;
	}
	
	public void setLeaderIdNum(String leaderIdNum) {
		this.leaderIdNum = leaderIdNum;
	}
	
	public Integer getLeaderSex() {
		return leaderSex;
	}
	
	public void setLeaderSex(Integer leaderSex) {
		this.leaderSex = leaderSex;
	}
	
	public Integer getCoachFlag() {
		return coachFlag;
	}
	
	public void setCoachFlag(Integer coachFlag) {
		this.coachFlag = coachFlag;
	}
	
	public String getCoachName() {
		return coachName;
	}
	
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	
	public String getCoachIdNum() {
		return coachIdNum;
	}
	
	public void setCoachIdNum(String coachIdNum) {
		this.coachIdNum = coachIdNum;
	}
	
	public String getCoachNum() {
		return coachNum;
	}
	
	public void setCoachNum(String coachNum) {
		this.coachNum = coachNum;
	}
	
	public Integer getCoachSex() {
		return coachSex;
	}
	
	public void setCoachSex(Integer coachSex) {
		this.coachSex = coachSex;
	}
	
	public String getCoachRemark() {
		return coachRemark;
	}
	
	public void setCoachRemark(String coachRemark) {
		this.coachRemark = coachRemark;
	}
	
	public Integer getDoctorFlag() {
		return doctorFlag;
	}
	
	public void setDoctorFlag(Integer doctorFlag) {
		this.doctorFlag = doctorFlag;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getDoctorNum() {
		return doctorNum;
	}
	
	public void setDoctorNum(String doctorNum) {
		this.doctorNum = doctorNum;
	}
	
	public String getDoctorIdNum() {
		return doctorIdNum;
	}
	
	public void setDoctorIdNum(String doctorIdNum) {
		this.doctorIdNum = doctorIdNum;
	}
	
	public Integer getDoctorSex() {
		return doctorSex;
	}
	
	public void setDoctorSex(Integer doctorSex) {
		this.doctorSex = doctorSex;
	}
	
	public String getDoctorRemark() {
		return doctorRemark;
	}
	
	public void setDoctorRemark(String doctorRemark) {
		this.doctorRemark = doctorRemark;
	}
	
	public Integer getTeamMemberId() {
		return teamMemberId;
	}
	
	public void setTeamMemberId(Integer teamMemberId) {
		this.teamMemberId = teamMemberId;
	}
	
	public int getMatchId() {
		return matchId;
	}
	
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	
	public Integer getTeamMaleNumber() {
		return teamMaleNumber;
	}
	
	public void setTeamMaleNumber(Integer teamMaleNumber) {
		this.teamMaleNumber = teamMaleNumber;
	}
	
	public Integer getTeamFemaleNumber() {
		return teamFemaleNumber;
	}
	
	public void setTeamFemaleNumber(Integer teamFemaleNumber) {
		this.teamFemaleNumber = teamFemaleNumber;
	}
	
	public Integer getTeamNumber() {
		return teamNumber;
	}
	
	public void setTeamNumber(Integer teamNumber) {
		this.teamNumber = teamNumber;
	}
	
	public String getTeamType() {
		return teamType;
	}
	
	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}
	
	public Integer getTeamTypeFlag() {
		return teamTypeFlag;
	}
	
	public void setTeamTypeFlag(Integer teamTypeFlag) {
		this.teamTypeFlag = teamTypeFlag;
	}
	
	public Integer getAthleteNumber() {
		return athleteNumber;
	}
	
	public void setAthleteNumber(Integer athleteNumber) {
		this.athleteNumber = athleteNumber;
	}
}
