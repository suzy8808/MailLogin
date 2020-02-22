package org.bobo.silence.mapper;

import org.bobo.silence.bean.SpSetting;

public interface SpSettingMapper {
    int deleteByPrimaryKey(String settingId);

    int insert(SpSetting record);

    int insertSelective(SpSetting record);

    SpSetting selectByPrimaryKey(String settingId);

    int updateByPrimaryKeySelective(SpSetting record);

    int updateByPrimaryKey(SpSetting record);
}