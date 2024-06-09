package com.escape.airplane.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.escape.airplane.domain.AirplaneVo;

@Mapper
public interface AirplaneMapper {

	List<AirplaneVo> getAirplaneInfo(AirplaneVo airplaneVo);

}
