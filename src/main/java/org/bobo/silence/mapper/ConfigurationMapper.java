package org.bobo.silence.mapper;

import org.bobo.silence.bean.Configuration;

public interface ConfigurationMapper {
    int deleteByPrimaryKey(String configId);

    int insert(Configuration record);

    int insertSelective(Configuration record);

    Configuration selectByPrimaryKey(String configId);

    int updateByPrimaryKeySelective(Configuration record);

    int updateByPrimaryKey(Configuration record);
}