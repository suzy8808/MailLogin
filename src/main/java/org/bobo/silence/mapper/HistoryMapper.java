package org.bobo.silence.mapper;

import org.bobo.silence.bean.History;

public interface HistoryMapper {
    int deleteByPrimaryKey(String historyId);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(String historyId);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
}