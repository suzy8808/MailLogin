package org.bobo.silence.mapper;

import org.bobo.silence.bean.Fan;

public interface FanMapper {
    int deleteByPrimaryKey(String fanId);

    int insert(Fan record);

    int insertSelective(Fan record);

    Fan selectByPrimaryKey(String fanId);

    int updateByPrimaryKeySelective(Fan record);

    int updateByPrimaryKey(Fan record);
}