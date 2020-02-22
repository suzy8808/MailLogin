package org.bobo.silence.controller;

import org.bobo.silence.common.result.ResultMap;
import org.bobo.silence.common.service.RedisService;
import org.bobo.silence.constant.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private RedisService redisService;

	@GetMapping("/hello")
	public ResultMap<String> hello() {
		System.out.println(redisService.get("ApplicationName"));
		return ResultMap.success(SystemConstant.SUCCESS, "HelloWorld");
	}

}
