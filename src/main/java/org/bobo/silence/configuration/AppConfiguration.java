package org.bobo.silence.configuration;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AppConfiguration {
	// 添加配置时，命名规则和key一致
	private String ApplicationName;
	private String SystemUID;
	private String BroadcastUID;
	private String MailIP;
	private String TokenExpireTime;

}
