package org.bobo.silence;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.bobo.silence.mapper")
public class SilenceApplication {

	public static void main(String[] args) {

		SpringApplication.run(SilenceApplication.class, args);

	}

//	@Configuration
//	class AppConfig {
//		@Autowired
//		private SileConfigurationMapper sileConfigurationMapper;
//
//		@Bean(value = "appConfig")
//		public RedisTemplate<String, String> cacheAppConfig() {
//			System.out.println("----------------------appConfig-----------------------");
//			RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//			ValueOperations<String, String> vo = redisTemplate.opsForValue();
//			List<org.bobo.silence.bean.Configuration> configurations = sileConfigurationMapper.selectAll();
//			for (org.bobo.silence.bean.Configuration config : configurations) {
//				vo.set(config.getConfigKey(), config.getConfigValue());
//			}
//			System.out.println("----------------------appConfig-----------------------");
//			return redisTemplate;
//		}
//	}

}
