package com.escape.airplane.controller;

import com.escape.airplane.domain.AirplaneTimeVo;
import com.escape.airplane.mapper.AirplaneMapper;
import com.escape.airplane.service.FlightService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/Airline")
public class AirlineController {

    @Autowired
    private FlightService flightService;
    
    @Autowired
	private AirplaneMapper airplaneMapper;

    @PostMapping("/Search")
    public ResponseEntity<Map<String, Object>> searchapi(@RequestParam Map<String, Object> params, AirplaneTimeVo airplaneTimeVo) {

    	System.out.println("===== Airline/Search === params1: " + params);
      
	      int stype = Integer.parseInt((String) params.get("stype"));
	      int adultCount = Integer.parseInt((String) params.get("adultCount"));
	      int childCount = Integer.parseInt((String) params.get("childCount"));
	      int infantCount = Integer.parseInt((String) params.get("infantCount"));
	      
	      List<Integer> ptypeList = new ArrayList<>();
	      if (adultCount > 0) ptypeList.add(1);
	      if (childCount > 0) ptypeList.add(2);
	      if (infantCount > 0) ptypeList.add(3);
	
	      params.put("ptypeList", ptypeList);
	      System.out.println("===== Airline/Search === params2: " + params);
	      
	      String initform = (String) params.get("initform");
	      List<AirplaneTimeVo> flightInfo;
	
	      if ("OW".equalsIgnoreCase(initform)) {
	          flightInfo = flightService.getOneWayFlightInfo(params);
	      } else {
	          flightInfo = flightService.getRoundTripFlightInfo(params);
	      }
	      
	      calculateDuration(flightInfo);
	      calculatePrice(flightInfo, adultCount, childCount, infantCount, stype, initform);
	      System.out.println("===== Airline/Search === flightInfo: " + flightInfo);
    	
        Map<String, Object> response = new HashMap<>();
        response.put("params", params);
        response.put("flightInfo", flightInfo);

        return ResponseEntity.ok(response);
    }
    
	// 소요시간 계산
	private void calculateDuration(List<AirplaneTimeVo> flightInfo) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for (AirplaneTimeVo flight : flightInfo) {
			
			String startTime1 = flight.getStartTime1().toString();
			String endTime1 = flight.getEndTime1().toString();

			LocalDateTime startDateTime = LocalDateTime.parse(startTime1, formatter);
	        LocalDateTime endDateTime = LocalDateTime.parse(endTime1, formatter);
	        
	        Duration duration = Duration.between(startDateTime, endDateTime);

			flight.setDurationhour(String.valueOf(duration.toHours()));
	        flight.setDurationminute(String.valueOf(duration.toMinutes() % 60));
		}
	}
	
	// 가격 계산
	private void calculatePrice(List<AirplaneTimeVo> flightInfo, int adultCount, int childCount, int infantCount, int stype, String initform) {
	    for (AirplaneTimeVo flight : flightInfo) {
	        int airplaneTimeIdx = flight.getAirplane_time_idx();

	        // 성인 가격 계산
	        int adultPrice = airplaneMapper.getPriceInfo(airplaneTimeIdx, 1, stype) * adultCount;
	        // 소아 가격 계산
	        int childPrice = airplaneMapper.getPriceInfo(airplaneTimeIdx, 2, stype) * childCount;
	        // 유아 가격 계산
	        int infantPrice = airplaneMapper.getPriceInfo(airplaneTimeIdx, 3, stype) * infantCount;

	        int totalPrice = adultPrice + childPrice + infantPrice;

	        flight.setTotalPrice(totalPrice);
	    }
	}
	
	@PostMapping("/Filter")
    public ResponseEntity<Map<String, Object>> filter(
            @RequestParam Map<String, Object> params,
            @RequestParam(value = "checkboxId[]", required = false) List<String> checkboxIds) throws JsonMappingException, JsonProcessingException {
        System.out.println("Airline/Filter-params1: " + params);

        int stype = Integer.parseInt((String) params.get("stype"));
        int adultCount = Integer.parseInt((String) params.get("adultCount"));
        int childCount = Integer.parseInt((String) params.get("childCount"));
        int infantCount = Integer.parseInt((String) params.get("infantCount"));

        List<Integer> ptypeList = new ArrayList<>();
        if (adultCount > 0) ptypeList.add(1);
        if (childCount > 0) ptypeList.add(2);
        if (infantCount > 0) ptypeList.add(3);

        params.put("ptypeList", ptypeList);

        boolean isChecked = Boolean.parseBoolean((String) params.get("isChecked"));
        System.out.println("Airline/Filter-isChecked: " + isChecked);
        System.out.println("Airline/Filter-checkboxIds: " + checkboxIds);

        List<TimeRange> departureTimes = new ArrayList<>();
        List<TimeRange> returnTimes = new ArrayList<>();

        Set<TimeRange> usedDepartTimeRanges = new HashSet<>();
        Set<TimeRange> usedReturnTimeRanges = new HashSet<>();
        
        ObjectMapper objectMapper = new ObjectMapper();
        String timeRangesJson1 = (String) params.get("timeRanges1");
        List<Map<String, String>> timeRanges1 = objectMapper.readValue(timeRangesJson1, new TypeReference<List<Map<String, String>>>(){});
        System.out.println("===== Airline/Filter-timeRanges1: " + timeRanges1);
        String timeRangesJson2 = (String) params.get("timeRanges2");
        List<Map<String, String>> timeRanges2 = objectMapper.readValue(timeRangesJson2, new TypeReference<List<Map<String, String>>>(){});
        System.out.println("===== Airline/Filter-timeRanges2: " + timeRanges2);

//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String timeRangesJson1 = (String) params.get("timeRanges1");
//            List<Map<String, String>> timeRanges1 = objectMapper.readValue(timeRangesJson1, new TypeReference<List<Map<String, String>>>(){});
//            System.out.println("===== Airline/Filter-timeRanges1: " + timeRanges1);
//
//            for (Map<String, String> range : timeRanges1) {
//                System.out.println("===== Airline/Filter-range: " + range);
//
//                TimeRange timeRange = new TimeRange(range.get("startTime1"), range.get("startTime2"));
//                System.out.println("===== Airline/Filter-timeRange: " + timeRange);
//
//                // 체크박스 아이디에 따라 departureTimes 또는 returnTimes에 추가
//                if (checkboxIds != null) {
//                    for (String checkboxId : checkboxIds) {
//                        System.out.println("===== Airline/Filter-checkboxId: " + checkboxId);
//                        if (checkboxId.startsWith("ckDep_")) {
//                            if (checkboxId.startsWith("ckDep_01") || checkboxId.startsWith("ckDep_02") || checkboxId.startsWith("ckDep_03") || checkboxId.startsWith("ckDep_04")) {
//                                if (!usedDepartTimeRanges.contains(timeRange)) {
//                                    departureTimes.add(timeRange);
//                                    usedDepartTimeRanges.add(timeRange); // 중복 체크
//                                }
//                            } else if (checkboxId.startsWith("ckDep_05") || checkboxId.startsWith("ckDep_06") || checkboxId.startsWith("ckDep_07") || checkboxId.startsWith("ckDep_08")) {
//                                if (!usedReturnTimeRanges.contains(timeRange)) {
//                                    returnTimes.add(timeRange);
//                                    usedReturnTimeRanges.add(timeRange); // 중복 체크
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//        	String timeRangesJson2 = (String) params.get("timeRanges2");
//        	List<Map<String, String>> timeRanges2 = objectMapper.readValue(timeRangesJson2, new TypeReference<List<Map<String, String>>>(){});
//        	System.out.println("===== Airline/Filter-timeRanges2: " + timeRanges2);
//        	
//        	for (Map<String, String> range : timeRanges2) {
//        		System.out.println("===== Airline/Filter-range: " + range);
//        		
//        		TimeRange timeRange = new TimeRange(range.get("startTime1"), range.get("startTime2"));
//        		System.out.println("===== Airline/Filter-timeRange: " + timeRange);
//        		
//        		// 체크박스 아이디에 따라 departureTimes 또는 returnTimes에 추가
//        		if (checkboxIds != null) {
//        			for (String checkboxId : checkboxIds) {
//        				System.out.println("===== Airline/Filter-checkboxId: " + checkboxId);
//        				if (checkboxId.startsWith("ckDep_")) {
//        					if (checkboxId.startsWith("ckDep_01") || checkboxId.startsWith("ckDep_02") || checkboxId.startsWith("ckDep_03") || checkboxId.startsWith("ckDep_04")) {
//        						if (!usedDepartTimeRanges.contains(timeRange)) {
//        							departureTimes.add(timeRange);
//        							usedDepartTimeRanges.add(timeRange); // 중복 체크
//        						}
//        					} else if (checkboxId.startsWith("ckDep_05") || checkboxId.startsWith("ckDep_06") || checkboxId.startsWith("ckDep_07") || checkboxId.startsWith("ckDep_08")) {
//        						if (!usedReturnTimeRanges.contains(timeRange)) {
//        							returnTimes.add(timeRange);
//        							usedReturnTimeRanges.add(timeRange); // 중복 체크
//        						}
//        					}
//        				}
//        			}
//        		}
//        	}
//        } catch (Exception e) {
//        	e.printStackTrace();
//        }
//
//        System.out.println("===== Airline/Filter-usedDepartTimeRanges: " + usedDepartTimeRanges);
//        System.out.println("===== Airline/Filter-usedReturnTimeRanges: " + usedReturnTimeRanges);

        params.put("departureTimes", departureTimes);
        params.put("returnTimes", returnTimes);
        params.put("timeRanges1", timeRanges1);
        params.put("timeRanges2", timeRanges2);

        System.out.println("Airline/Filter-params2: " + params);

        String initform = (String) params.get("initform");
        List<AirplaneTimeVo> flightInfo;

        if ("OW".equalsIgnoreCase(initform)) {
            flightInfo = flightService.getOneWayFilterInfo(params);
        } else {
            flightInfo = flightService.getRoundTripFilterInfo(params);
        }

        calculateDuration(flightInfo);
        calculatePrice(flightInfo, adultCount, childCount, infantCount, stype, initform);
        System.out.println("Airline/Filter-flightInfo: " + flightInfo);

        Map<String, Object> response = new HashMap<>();
        response.put("params", params);
        response.put("flightInfo", flightInfo);

        return ResponseEntity.ok(response);
    }
	
	static class TimeRange {
        private String startTime1;
        private String startTime2;

        public TimeRange(String startTime1, String startTime2) {
            this.startTime1 = startTime1;
            this.startTime2 = startTime2;
        }

        // Getters and setters
        public String getStartTime1() {
            return startTime1;
        }

        public void setStartTime(String startTime1) {
            this.startTime1 = startTime1;
        }

        public String getStartTime2() {
            return startTime2;
        }

        public void setStartTime2(String startTime2) {
            this.startTime2 = startTime2;
        }

        // toString 오버라이드
        @Override
        public String toString() {
            return "TimeRange{" +
                    "startTime1='" + startTime1 + '\'' +
                    ", startTime2='" + startTime2 + '\'' +
                    '}';
        }

        // equals와 hashCode 오버라이드
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TimeRange timeRange = (TimeRange) o;
            return Objects.equals(startTime1, timeRange.startTime2) &&
                    Objects.equals(startTime2, timeRange.startTime2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startTime1, startTime2);
        }
    }
	
}