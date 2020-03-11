package cn.shop.common.utils;

import cn.shop.common.ex.ArgumentException;
import cn.shop.common.ex.ServiceException;

/**
 * 校验工具
 */
public class Assert {

	public static void isArgumentException(boolean statement, String reason) {
		if(statement) throw new ArgumentException(reason);
	}

	public static void isServiceException(boolean statement, String reason) {
		if(statement) throw new ServiceException(reason);
	}
}
