package org.bobo.silence.configuration;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.bobo.silence.mapper.silemapper.SileConfigurationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Configuration
public class AppConfig {
	@Autowired
	private SileConfigurationMapper sileConfigurationMapper;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Bean
	public AppConfiguration cacheAppConfig()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		System.out.println("----------------------appConfig-----------------------");
		AppConfiguration appConfiguration = new AppConfiguration();
		ValueOperations<String, Object> vo = redisTemplate.opsForValue();
		List<org.bobo.silence.bean.Configuration> configurations = sileConfigurationMapper.selectAll();
		for (org.bobo.silence.bean.Configuration config : configurations) {
			vo.set(config.getConfigKey(), config.getConfigValue());
			Field field = appConfiguration.getClass().getDeclaredField(config.getConfigKey());

			field.setAccessible(true);
			field.set(appConfiguration, config.getConfigValue());
		}
		System.out.println(appConfiguration);
		System.out.println("----------------------appConfig-----------------------");
		return appConfiguration;
	}
}
