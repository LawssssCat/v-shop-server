package cn.shop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.shop.model.po.Manager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ManagerServiceTest {

	@Autowired
	private ManagerService managerService;

	@Test
	public void findByName_success() {
		Manager manager = managerService.findByName("admin");
		log.info("manager={}", manager);
	}

	@Test
	public void findByName_fail_1() {
		// 没数据
		Manager manager = managerService.findByName("aaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	@Test
	public void findByName_fail_2() {
		// 参数错误
		managerService.findByName(null);
	}
}
