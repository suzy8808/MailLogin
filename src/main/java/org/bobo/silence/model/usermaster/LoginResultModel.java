package org.bobo.silence.model.usermaster;

import org.bobo.silence.bean.Token;
import org.bobo.silence.bean.UserMaster;
import org.bobo.silence.common.result.ResultStatus;

import lombok.Data;

@Data
public class LoginResultModel {
	private UserMaster userMaster;
	private Token token;
	private ResultStatus resultStatus;
}
