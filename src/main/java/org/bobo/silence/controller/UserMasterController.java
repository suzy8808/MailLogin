package org.bobo.silence.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bobo.silence.common.handler.BindErrorHandler;
import org.bobo.silence.common.result.ResultMap;
import org.bobo.silence.common.result.ResultStatus;
import org.bobo.silence.constant.SystemConstant;
import org.bobo.silence.model.usermaster.CheckValidateModel;
import org.bobo.silence.model.usermaster.EmailValidateSendModel;
import org.bobo.silence.model.usermaster.LoginModel;
import org.bobo.silence.model.usermaster.LoginResultModel;
import org.bobo.silence.model.usermaster.RegisterModel;
import org.bobo.silence.service.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usermaster")
public class UserMasterController {

	@Autowired
	private UserMasterService userMasterService;

//----------------------	认证系不用检测token
	@PostMapping("/email_validate_send")
	public ResultMap<Boolean> emailValidateSend(@RequestBody @Validated EmailValidateSendModel dataModel,
			BindingResult bind, HttpServletRequest request) {
		ResultStatus resultStatus = null;
		// check
		if (bind.hasFieldErrors()) {
			BindErrorHandler.handle(resultStatus, bind);
			return ResultMap.failure(resultStatus, false);
		}
		userMasterService.sendValidateMail(dataModel);
		return ResultMap.success(SystemConstant.SUCCESS, true);

	}

	@GetMapping("/email_activate")
	public ResultMap<String> emailActivate(@RequestParam String code) {
		ResultStatus resultStatus = null;
		// check
		if (StringUtils.isEmpty(code)) {

			return ResultMap.failure(new ResultStatus(SystemConstant.FIELD_ERROR, SystemConstant.FIELD_ERROR_MSG),
					code);
		}
		resultStatus = userMasterService.activateValidate(code);
		return ResultMap.success(resultStatus, code);

	}

	@PostMapping("/check_validate")
	public ResultMap<String> checkValidate(@RequestBody @Validated CheckValidateModel dataModel, BindingResult bind,
			HttpServletRequest request) {
		ResultStatus resultStatus = null;
		// check
		if (bind.hasFieldErrors()) {
			BindErrorHandler.handle(resultStatus, bind);
			return ResultMap.failure(resultStatus, dataModel.getCode());
		}
		resultStatus = userMasterService.checkValidate(dataModel);
		return ResultMap.success(resultStatus, dataModel.getCode());

	}

	@PostMapping("/register")
	public ResultMap<Boolean> register(@RequestBody @Validated RegisterModel dataModel, BindingResult bind,
			HttpServletRequest request) {
		ResultStatus resultStatus = null;
		// check
		if (bind.hasFieldErrors()) {
			BindErrorHandler.handle(resultStatus, bind);
			return ResultMap.failure(resultStatus, false);
		}

		resultStatus = userMasterService.register(dataModel);

		return ResultMap.success(resultStatus, true);
	}

	@PostMapping("/login")
	public ResultMap<Map<String, Object>> login(@RequestBody @Validated LoginModel dataModel, BindingResult bind,
			HttpServletRequest request) {
		ResultStatus resultStatus = null;
		// check
		if (bind.hasFieldErrors()) {
			BindErrorHandler.handle(resultStatus, bind);
			return ResultMap.failure(resultStatus, null);
		}

		LoginResultModel loginResultModel = userMasterService.login(dataModel);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userMaster", loginResultModel.getUserMaster());
		map.put("token", loginResultModel.getToken());

		return ResultMap.success(loginResultModel.getResultStatus(), map);
	}
//----------------------	认证系不用检测token
}
