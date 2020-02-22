package org.bobo.silence.controller;

import org.bobo.silence.common.result.ResultMap;
import org.bobo.silence.constant.SystemConstant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class WorkController {

	@PostMapping("/upload_work")
	public ResultMap<Boolean> uploadWork() {
		// TODO

		return ResultMap.success(SystemConstant.SUCCESS, true);

	}
}
