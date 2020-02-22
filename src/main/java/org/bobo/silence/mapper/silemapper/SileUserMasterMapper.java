package org.bobo.silence.mapper.silemapper;

import org.apache.ibatis.annotations.Mapper;
import org.bobo.silence.bean.UserMaster;

@Mapper
public interface SileUserMasterMapper {

	UserMaster selectByEmail(String email);

	UserMaster selectByNickName(String nickName);

}