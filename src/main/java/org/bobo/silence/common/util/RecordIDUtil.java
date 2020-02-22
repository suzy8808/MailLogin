package org.bobo.silence.common.util;

import java.util.UUID;

import org.bobo.silence.constant.SystemConstant;
import org.springframework.util.DigestUtils;

public class RecordIDUtil {
	public static String createUserMasterID() {
		String id = UUID.randomUUID().toString();
		return SystemConstant.USER_ID_START + "*" + id;
	}

	public static String createValidateID() {
		String id = UUID.randomUUID().toString();

		return String.valueOf(id);
	}

	public static String createToken() {
		String id = UUID.randomUUID().toString();
		String md5Str = id + SystemConstant.MD5_SALT;
		String token = DigestUtils.md5DigestAsHex(md5Str.getBytes());
		return token;
	}
}
