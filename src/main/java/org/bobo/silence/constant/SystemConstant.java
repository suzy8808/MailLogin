package org.bobo.silence.constant;

import org.bobo.silence.common.result.ResultStatus;

public class SystemConstant {

	public static final int DISABLE = 1;
	public static final int ABLE = 0;

	// Errors Code
	public static final int FIELD_ERROR = 501;
	public static final String FIELD_ERROR_MSG = "参数不正确";

	// UserID Start
	public static final String USER_ID_START = "soul";

	// common result status
	public static final ResultStatus SUCCESS = new ResultStatus(200, "OK");
	public static final ResultStatus BAD_REQUEST = new ResultStatus(400, "Bad Request");
	public static final ResultStatus INTERNAL_SERVER_ERROR = new ResultStatus(500, "Internal Server Error");
	public static final ResultStatus EMAIL_EXISTS_ERROR = new ResultStatus(502, "该邮箱已注册");
	public static final ResultStatus VALIDATE_HAS_ACTIVATED = new ResultStatus(503, "该验证已被激活");
	public static final ResultStatus VALIDATE_NOT_ACTIVATED = new ResultStatus(504, "该验证未被激活");
	public static final ResultStatus NICKNAME_EXISTS_ERROR = new ResultStatus(505, "昵称的高地已被别人占领");
	public static final ResultStatus LOGIN_ERROR = new ResultStatus(506, "您老贵人多忘事，邮箱或密码有误");

	// md5 salt
	public static final String MD5_SALT = "tzzssbsq";

}
