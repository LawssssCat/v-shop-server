package cn.shop.common.config;

import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	@Bean("shiroManager")
	public SecurityManager securityManager() {
		SecurityManager manager = new DefaultWebSecurityManager();
		return manager;
	}

	//资源访问拦截器
	@Bean("shiroFilterFactory")
	@Autowired
	public ShiroFilterFactoryBean shiroFilterFactoryBean(
			@Qualifier("shiroManager") SecurityManager manager) {
		ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
		factory.setSecurityManager(manager);
		// 映射:路径-访问要求(anon/authc/...)
		Map<String, String> map = factory.getFilterChainDefinitionMap() ;
		// 测试登录是否成功
		map.put("/hello/shiro", "authc") ; 
		return factory ; 
	}
	
}
