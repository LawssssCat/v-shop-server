package cn.shop.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

	@RequestMapping("/now")
	public Date showTime() {
		return new Date() ; 
	}
}
