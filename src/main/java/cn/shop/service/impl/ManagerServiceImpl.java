package cn.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.shop.common.utils.Assert;
import cn.shop.mapper.ManagerMapper;
import cn.shop.model.po.Manager;
import cn.shop.service.ManagerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerMapper managerMapper;

	@Override
	public Manager findByName(String name) {
		Assert.isArgumentException(StringUtils.isEmpty(name), "请传入名字");
		log.debug("name={}", name);
		Manager manager = managerMapper.selectOne(new QueryWrapper<Manager>(new Manager().setName(name)));
		Assert.isServiceException(ObjectUtils.isEmpty(manager), "没有数据");
		return manager;
	}

}
