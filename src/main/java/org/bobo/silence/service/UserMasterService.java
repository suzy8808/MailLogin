package org.bobo.silence.service;

import javax.mail.MessagingException;

import org.bobo.silence.bean.Token;
import org.bobo.silence.bean.UserMaster;
import org.bobo.silence.bean.Validate;
import org.bobo.silence.common.result.ResultStatus;
import org.bobo.silence.common.service.MailService;
import org.bobo.silence.common.util.DateUtil;
import org.bobo.silence.common.util.RecordIDUtil;
import org.bobo.silence.configuration.AppConfiguration;
import org.bobo.silence.constant.SystemConstant;
import org.bobo.silence.mapper.TokenMapper;
import org.bobo.silence.mapper.UserMasterMapper;
import org.bobo.silence.mapper.ValidateMapper;
import org.bobo.silence.mapper.silemapper.SileUserMasterMapper;
import org.bobo.silence.model.usermaster.CheckValidateModel;
import org.bobo.silence.model.usermaster.EmailValidateSendModel;
import org.bobo.silence.model.usermaster.LoginModel;
import org.bobo.silence.model.usermaster.LoginResultModel;
import org.bobo.silence.model.usermaster.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserMasterService {
	@Autowired
	private AppConfiguration appConfiguration;
	@Autowired
	private UserMasterMapper userMasterMapper;
	@Autowired
	private ValidateMapper validateMapper;
	@Autowired
	private SileUserMasterMapper sileUserMasterMapper;
	@Autowired
	private TokenMapper tokenMapper;
	@Autowired
	private MailService mailService;

	@Async
	public void sendValidateMail(EmailValidateSendModel dataModel) {
		String mailIP = appConfiguration.getApplicationName();
		String id = RecordIDUtil.createValidateID();
		Validate validate = new Validate();
		validate.setValidateId(id);
		validate.setEmail(dataModel.getEmail());
		validate.setState(SystemConstant.DISABLE);
		validateMapper.insertSelective(validate);
		String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://" + mailIP
				+ ":8080/silence/usermaster/email_activate?code=" + id + "'>http://" + mailIP
				+ ":8080/silence/usermaster/email_activate?code=" + id + "</href></h3></body></html>";
		System.out.println(content);
		try {
			mailService.sendHtmlMail(dataModel.getEmail(), "邮箱激活", content);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public ResultStatus activateValidate(String code) {

		Validate validate = validateMapper.selectByPrimaryKey(code);
		if (validate == null || validate.getState() == SystemConstant.ABLE) {

			return SystemConstant.VALIDATE_HAS_ACTIVATED;
		}

		validate = new Validate();
		validate.setValidateId(code);
		validate.setState(0);
		validateMapper.updateByPrimaryKeySelective(validate);
		return SystemConstant.SUCCESS;
	}

	public ResultStatus checkValidate(CheckValidateModel dataModel) {

		Validate validate = validateMapper.selectByPrimaryKey(dataModel.getCode());
		if (validate == null || validate.getState() == SystemConstant.DISABLE) {

			return SystemConstant.VALIDATE_NOT_ACTIVATED;
		}
		return SystemConstant.SUCCESS;
	}

	public LoginResultModel login(LoginModel dataModel) {
		LoginResultModel loginResultModel = new LoginResultModel();
		UserMaster userMaster = sileUserMasterMapper.selectByEmail(dataModel.getEmail());
		if (userMaster == null || !dataModel.getPassword().equals(userMaster.getPassword())) {
			loginResultModel.setResultStatus(SystemConstant.LOGIN_ERROR);
			return loginResultModel;
		}
		userMaster.setPassword(null);

		// 生成token
		Token token = new Token();
		token.setToken(RecordIDUtil.createToken());
		token.setUserId(userMaster.getUserId());
		token.setExpireTime(DateUtil.addDay(DateUtil.now(), Integer.valueOf(appConfiguration.getTokenExpireTime())));
		tokenMapper.insertSelective(token);
		loginResultModel.setResultStatus(SystemConstant.SUCCESS);
		loginResultModel.setToken(token);
		loginResultModel.setUserMaster(userMaster);
		return loginResultModel;
	}

	public ResultStatus register(RegisterModel dataModel) {
		// 验证email是否被激活
		Validate validate = validateMapper.selectByPrimaryKey(dataModel.getValidateId());
		if (validate == null || validate.getState() != SystemConstant.ABLE) {
			return SystemConstant.VALIDATE_NOT_ACTIVATED;
		}

		// 验证email重复
		UserMaster userMaster = sileUserMasterMapper.selectByEmail(dataModel.getEmail());
		if (userMaster != null) {
			return SystemConstant.EMAIL_EXISTS_ERROR;
		}

		// 验证nickName重复
		userMaster = sileUserMasterMapper.selectByNickName(dataModel.getNickName());
		if (userMaster != null) {
			return SystemConstant.NICKNAME_EXISTS_ERROR;
		}

		String id = RecordIDUtil.createUserMasterID();
		userMaster = new UserMaster();
		userMaster.setUserId(id);
		userMaster.setNickName(dataModel.getNickName());
		userMaster.setEmail(dataModel.getEmail());
		userMaster.setPassword(dataModel.getPassword());
		userMasterMapper.insertSelective(userMaster);

		return SystemConstant.SUCCESS;
	}
}
