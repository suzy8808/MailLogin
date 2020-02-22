package org.bobo.silence.mapper;

import org.bobo.silence.bean.UserWorkRls;

public interface UserWorkRlsMapper {
    int deleteByPrimaryKey(String uwRlsId);

    int insert(UserWorkRls record);

    int insertSelective(UserWorkRls record);

    UserWorkRls selectByPrimaryKey(String uwRlsId);

    int updateByPrimaryKeySelective(UserWorkRls record);

    int updateByPrimaryKey(UserWorkRls record);
}