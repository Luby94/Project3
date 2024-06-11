package com.escape.airplane.controller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.escape.airplane.domain.AirplaneSearchVo;
import com.escape.airplane.domain.AirplaneVo;
import com.escape.airplane.domain.AirportVo;
import com.escape.airplane.domain.CityVo;
import com.escape.airplane.mapper.AirplaneMapper;

@Controller
@RequestMapping("/Airplane")
public class AirplaneController {

	@Autowired
	private AirplaneMapper airplaneMapper;
	
	@RequestMapping("/Main")
	public ModelAndView main( AirplaneVo airplaneVo ) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("airplane/airplanemain");
		return mv;
		
	}
	
	@RequestMapping("/Search")
	@ResponseBody
	public ModelAndView search(
				@RequestParam Map<String, String> params,
				@RequestParam(value="depDate2[]", required = false) List<String> depDates2,
				AirplaneVo airplaneVo,
				AirplaneSearchVo airplaneSearchVo,
				AirportVo airportVo,
				CityVo cityVo
			 ) {
		
		// 1. airplanemain.jsp 에서 선택한 항공권 조건 value 값 받기 
		String depCity1 = params.get("depCity1");
		String depCity2 = params.get("depCity2");
	    String ariCity1 = params.get("ariCity1");
	    String ariCity2 = params.get("ariCity2");
	    String depCityCode1 = params.get("depCityCode1");
	    String depCityCode2 = params.get("depCityCode2");
	    String ariCityCode1 = params.get("ariCityCode1");
	    String ariCityCode2 = params.get("ariCityCode2");
	    String depDate1 = params.get("depDate1");
	    String initform = params.get("initform");
	    String seatClass = params.get("seatClass");

	    String adultCountStr = params.get("adultCount");
	    int adultCount = Integer.parseInt(adultCountStr);
	    String childCountStr = params.get("childCount");
	    int childCount = Integer.parseInt(childCountStr);
	    String infantCountStr = params.get("infantCount");
	    int infantCount = Integer.parseInt(infantCountStr);
	    
	    System.out.println("=======params: " + params);
		System.out.println("=======depCity1: " + depCity1);
		System.out.println("=======ariCity1: " + ariCity1);
		System.out.println("=======depCityCode1: " + depCityCode1);
		System.out.println("=======ariCityCode1: " + ariCityCode1);
		System.out.println("=======depCity2: " + depCity2);
		System.out.println("=======ariCity2: " + ariCity2);
		System.out.println("=======depCityCode2: " + depCityCode2);
		System.out.println("=======ariCityCode2: " + ariCityCode2);
		System.out.println("=======depDate1: " + depDate1);
		System.out.println("=======depDate2[]: " + depDates2);
		System.out.println("=======initform: " + initform);
		System.out.println("=======seatClass: " + seatClass);
		System.out.println("=======adultCount: " + adultCount);
		System.out.println("=======childCount: " + childCount);
		System.out.println("=======infantCount: " + infantCount);
		
		// 2. 넘어온 값 DB 조회 위한 객체배열 생성
		List<Map<String, Object>> airSearchList = new ArrayList<>();

	    if ("RT".equals(initform) && depDates2 != null) {
	    	
	        // 도시 정보를 인덱스로 변경
	        List<CityVo> departureLoc1 = airplaneMapper.getDepartureInfo(depCity1);
	        CityVo dfirstAirplane1 = departureLoc1.get(0);
	        int departure_loc1 = dfirstAirplane1.getCity_idx();

	        List<CityVo> arrivalLoc1 = airplaneMapper.getArrivalInfo(ariCity1);
	        CityVo afirstAirplane1 = arrivalLoc1.get(0);
	        int arrival_loc1 = afirstAirplane1.getCity_idx();

	        List<CityVo> departureLoc2 = airplaneMapper.getDepartureInfo(depCity2);
	        CityVo dfirstAirplane2 = departureLoc2.get(0);
	        int departure_loc2 = dfirstAirplane2.getCity_idx();

	        List<CityVo> arrivalLoc2 = airplaneMapper.getArrivalInfo(ariCity2);
	        CityVo afirstAirplane2 = arrivalLoc2.get(0);
	        int arrival_loc2 = afirstAirplane2.getCity_idx();

	        // depDates2 배열의 각 날짜 처리
	        for (String depDate2 : depDates2) {
	            List<Map<String, Object>> tempList;
	            if (depDate2.equals(depDates2.get(0))) {
	                // 첫 번째 날짜는 원래 출발지와 도착지 사용
	                tempList = airplaneMapper.getTimeList(depDate2, departure_loc1, arrival_loc1);
	                System.out.println("===== tempList1 =====: " + tempList);
	            } else {
	                // 두 번째 날짜는 출발지와 도착지를 변경
	                tempList = airplaneMapper.getTimeList(depDate2, departure_loc2, arrival_loc2);
	                System.out.println("===== tempList2 =====: " + tempList);
	            }
	            airSearchList.addAll(tempList);
	        }
	        
	        calculateDuration(airSearchList);
	        
	    } else {
	    	
	        // 편도 여행의 경우
	        List<CityVo> departureLoc1 = airplaneMapper.getDepartureInfo(depCity1);
	        CityVo dfirstAirplane1 = departureLoc1.get(0);
	        int departure_loc1 = dfirstAirplane1.getCity_idx();

	        List<CityVo> arrivalLoc1 = airplaneMapper.getArrivalInfo(ariCity1);
	        CityVo afirstAirplane1 = arrivalLoc1.get(0);
	        int arrival_loc1 = afirstAirplane1.getCity_idx();

	        List<Map<String, Object>> tempList = airplaneMapper.getTimeList(depDate1, departure_loc1, arrival_loc1);
	        System.out.println("===== tempList3 =====: " + tempList);
	        airSearchList.addAll(tempList);
	        
	        calculateDuration(airSearchList);
	        
	    }
		
	    System.out.println("===== airSearchList =====: " + airSearchList);
	    
		ModelAndView mv = new ModelAndView();
		mv.addObject("airSearchList", airSearchList);
		mv.setViewName("airplane/airplanesearch");
		return mv;
		
	}
	
	// 소요시간 계산
	private void calculateDuration(List<Map<String, Object>> flights) {
	    for (Map<String, Object> flight : flights) {
	        Object startTimeObj = flight.get("START_TIME");
	        String startTime = startTimeObj != null ? startTimeObj.toString() : null;
	        Object endTimeObj = flight.get("END_TIME");
	        String endTime = endTimeObj != null ? endTimeObj.toString() : null;
	        
	        if (startTime != null && endTime != null) {
	            Duration duration = Duration.between(LocalTime.parse(startTime), LocalTime.parse(endTime));
	            Long durationHour = duration.toHours();
	            Long durationMinutes = duration.toMinutes() % 60;
	            
	            flight.put("DURATIONHOUR", durationHour.toString());
	            flight.put("DURATIONMINUTE", durationMinutes.toString());
	        }
	    }
	}

	
}