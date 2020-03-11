package cn.shop.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

	private CorsConfiguration corsConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		/*
		 * 请求常用的三种配置，*代表允许所有，当然你也可以自定义属性（比如header只能带什么，只能是post方式等等）
		 */
		// 允许访问的客户端域名
		corsConfiguration.addAllowedOrigin("*");
		// 允许任何请求头 可选: "x-requested-with,X-Nideshop-Token,X-URL-PATH"
		corsConfiguration.addAllowedHeader("*");
		// 允许任何方法 可选: "POST, GET, OPTIONS, DELETE"
		corsConfiguration.addAllowedMethod("*");
		// 允许请求带有验证信息
		corsConfiguration.setAllowCredentials(true);
		// maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
		corsConfiguration.setMaxAge(3600L);
		return corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		// 拦截本域名下的所有请求
		source.registerCorsConfiguration("/**", corsConfig()); // 设置头配置信息
		return new CorsFilter(source);
	}
}
