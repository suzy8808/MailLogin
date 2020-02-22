package org.bobo.silence.mapper;

import org.bobo.silence.bean.MsgSetting;

public interface MsgSettingMapper {
    int deleteByPrimaryKey(String settingId);

    int insert(MsgSetting record);

    int insertSelective(MsgSetting record);

    MsgSetting selectByPrimaryKey(String settingId);

    int updateByPrimaryKeySelective(MsgSetting record);

    int updateByPrimaryKey(MsgSetting record);
}