package org.bobo.silence.mapper;

import org.bobo.silence.bean.BlackList;

public interface BlackListMapper {
    int deleteByPrimaryKey(String blId);

    int insert(BlackList record);

    int insertSelective(BlackList record);

    BlackList selectByPrimaryKey(String blId);

    int updateByPrimaryKeySelective(BlackList record);

    int updateByPrimaryKey(BlackList record);
}