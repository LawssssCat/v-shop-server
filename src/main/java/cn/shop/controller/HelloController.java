package cn.shop.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.shop.common.utils.JsonResult;

@RequestMapping("/hello")
@RestController
public class HelloController {

	@RequestMapping("/now")
	public Date showTime() {
		return new Date();
	}

	@RequestMapping("/cors")
	public JsonResult corsJsonResult() {
		return JsonResult.ok("cors success!");
	}
}
