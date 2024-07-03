package com.escape.airplane.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escape.airplane.domain.AirplaneTimeVo;
import com.escape.airplane.mapper.AirplaneMapper;

@Service
public class FlightService {

    @Autowired
    private AirplaneMapper airplaneMapper;

    /*
    public List<AirplaneTimeVo> getFlightInfo(Map<String, Object> params) {
        formatDateParams(params);
        return airplaneMapper.getFlightInfo(params);
    }
    */
    
    public List<AirplaneTimeVo> getOneWayFlightInfo(Map<String, Object> params) {
        formatDateParams(params);
        return airplaneMapper.getOneWayFlightInfo(params);
    }

    public List<AirplaneTimeVo> getRoundTripFlightInfo(Map<String, Object> params) {
        formatDateParams(params);
        return airplaneMapper.getRoundTripFlightInfo(params);
    }

    private void formatDateParams(Map<String, Object> params) {
        if (params.containsKey("depDate")) {
            String depDateStr = (String) params.get("depDate");
            LocalDate depDate = LocalDate.parse(depDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            params.put("depDate", depDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            LocalDate depDatePlusOne = depDate.plusDays(1);
            params.put("depDate2", depDatePlusOne.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        if (params.containsKey("arrDate")) {
            String arrDateStr = (String) params.get("arrDate");
            LocalDate arrDate = LocalDate.parse(arrDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate arrDatePlusOne = arrDate.plusDays(1);
            params.put("arrDate", arrDatePlusOne.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
    }
    
    // 필터링-시간대
    public List<AirplaneTimeVo> getFilteredFlights(String depDate, String arrDate, String depCity1, String arrCity1, int stype, List<Integer> ptypeList, List<Map<String, String>> departureTimes) {
        Map<String, Object> params = new HashMap<>();
        params.put("depDate", depDate);
        params.put("arrDate", arrDate);
        params.put("depCity1", depCity1);
        params.put("arrCity1", arrCity1);
        params.put("stype", stype);
        params.put("ptypeList", ptypeList);
        params.put("departureTimes", departureTimes);

        return airplaneMapper.getRoundTripFlightInfo(params);
    }
}
