package com.steins.service;


import com.steins.dto.AreaExecution;
import com.steins.entity.Area;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AreaService {
	public static final String USERMATCHKEY = "usermatch";

	/**
	 * 获取区域列表，优先从缓存获取
	 * 
	 * @return
	 */
	List<Area> getAreaList();

	/**
	 * 增加区域信息
	 * 
	 * @param area
	 * @return
	 */
	AreaExecution addArea(Area area);

	/**
	 * 修改区域信息
	 * 
	 * @param area
	 * @return
	 */
	AreaExecution modifyArea(Area area);
	
//	@Transactional
//	AreaExecution addArea(Area area);
}
