package com.steins.enums;

public enum GameApplyEnum {OFFLINE(-1, "非法区域"), SUCCESS(0, "操作成功"), INNER_ERROR(-1001, "操作失败"), EMPTY(
		-1002, "区域信息为空");
	
	private int state;
	
	private String stateInfo;
	
	private GameApplyEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	public int getState() {
		return state;
	}
	
	public String getStateInfo() {
		return stateInfo;
	}
	
	public static GameApplyEnum stateOf(int index) {
		for (GameApplyEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
	
}
