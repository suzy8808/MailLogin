package org.bobo.silence.mapper;

import org.bobo.silence.bean.UserCommentRls;

public interface UserCommentRlsMapper {
    int deleteByPrimaryKey(String ucRlsId);

    int insert(UserCommentRls record);

    int insertSelective(UserCommentRls record);

    UserCommentRls selectByPrimaryKey(String ucRlsId);

    int updateByPrimaryKeySelective(UserCommentRls record);

    int updateByPrimaryKey(UserCommentRls record);
}