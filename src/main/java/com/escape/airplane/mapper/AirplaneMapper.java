package com.escape.airplane.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.escape.airplane.domain.AirplaneSearchVo;
import com.escape.airplane.domain.AirplaneVo;

@Mapper
public interface AirplaneMapper {

	//List<AirplaneVo> getAirplaneInfo(AirplaneVo airplaneVo);
	//List<AirplaneVo> getAirplaneInfo(String depCity);
	List<AirplaneVo> getDepartureInfo(String depCity);
	List<AirplaneVo> getArrivalInfo(String ariCity);

	//List<AirplaneSearchVo> getTimeList(AirplaneSearchVo airplaneSearchVo);
	List<AirplaneSearchVo> getTimeList(String depDate, String arrdate, int departure_loc, int arrival_loc);



}
