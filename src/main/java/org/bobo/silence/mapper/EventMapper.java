package org.bobo.silence.mapper;

import org.bobo.silence.bean.Event;

public interface EventMapper {
    int deleteByPrimaryKey(String eventId);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(String eventId);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKeyWithBLOBs(Event record);

    int updateByPrimaryKey(Event record);
}