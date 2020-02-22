package org.bobo.silence.mapper;

import org.bobo.silence.bean.Validate;

public interface ValidateMapper {
    int deleteByPrimaryKey(String validateId);

    int insert(Validate record);

    int insertSelective(Validate record);

    Validate selectByPrimaryKey(String validateId);

    int updateByPrimaryKeySelective(Validate record);

    int updateByPrimaryKey(Validate record);
}