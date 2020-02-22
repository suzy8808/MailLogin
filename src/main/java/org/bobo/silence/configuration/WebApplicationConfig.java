package org.bobo.silence.configuration;

import org.bobo.silence.interceptor.ApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

	@Autowired
	private ApiInterceptor apiInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(new
		// ApiInterceptor()).addPathPatterns("/**").excludePathPatterns("/login",
		// "/register");
		registry.addInterceptor(apiInterceptor).addPathPatterns("/**");
	}

}
