package cn.shop.service;

import cn.shop.model.po.Manager;

public interface ManagerService {
	
	/**
	 * 根据名字找管理员
	 * @param name
	 * @return
	 */
	Manager findByName(String name) ;
}
