package org.bobo.silence.mapper;

import org.bobo.silence.bean.UserMaster;

public interface UserMasterMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserMaster record);

    int insertSelective(UserMaster record);

    UserMaster selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserMaster record);

    int updateByPrimaryKey(UserMaster record);
}