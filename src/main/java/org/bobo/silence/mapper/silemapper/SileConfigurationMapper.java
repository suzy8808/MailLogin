package org.bobo.silence.mapper.silemapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.bobo.silence.bean.Configuration;

@Mapper
public interface SileConfigurationMapper {
	List<Configuration> selectAll();
}
