package org.bobo.silence.mapper;

import org.bobo.silence.bean.WorkType;

public interface WorkTypeMapper {
    int deleteByPrimaryKey(String typeId);

    int insert(WorkType record);

    int insertSelective(WorkType record);

    WorkType selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(WorkType record);

    int updateByPrimaryKey(WorkType record);
}