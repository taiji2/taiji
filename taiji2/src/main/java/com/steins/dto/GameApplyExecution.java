package com.steins.dto;

import com.steins.entity.GameApply;

import com.steins.enums.GameApplyEnum;

import java.util.List;

/**
 * @author Sunny
 */
public class GameApplyExecution {
	// 结果状态
	private int state;
	
	// 状态标识
	private String stateInfo;
	
	// 店铺数量
	private int count;
	
	// 操作的award（增删改商品的时候用）
	private GameApply gameApply;
	
	// 获取的award列表(查询商品列表的时候用)
	private List<GameApply> gameApplyList;
	
	public GameApplyExecution() {
	}

	// 失败的构造器
	public GameApplyExecution(GameApplyEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}
	
	// 成功的构造器
	public GameApplyExecution(GameApplyEnum stateEnum, GameApply gameApply) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.gameApply = gameApply;
	}
	
	// 成功的构造器
	public GameApplyExecution(GameApplyEnum stateEnum, List<GameApply> gameApplyList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.gameApplyList = gameApplyList;
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
	
	public GameApply getGameApply() {
		return gameApply;
	}
	
	public void setGameApply(GameApply gameApply) {
		this.gameApply = gameApply;
	}
	
	public List<GameApply> getGameApplyList() {
		return gameApplyList;
	}
	
	public void setGameApplyList(List<GameApply> gameApplyList) {
		this.gameApply = gameApply;
	}
	
}
