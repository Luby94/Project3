package com.escape.airplane.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.escape.airplane.domain.AirplaneVo;
import com.escape.airplane.mapper.AirplaneMapper;

@Controller
@RequestMapping("/Airplane")
public class AirplaneController {

	@Autowired
	private AirplaneMapper airplaneMapper;
	
	@RequestMapping("/Main")
	public ModelAndView main( AirplaneVo airplaneVo ) {

		List<AirplaneVo> airplaneList = airplaneMapper.getAirplaneInfo( airplaneVo );
		//System.out.println( "=====Airplane/Main===== airplaneList: " + airplaneList );
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("airplaneList", airplaneList);
		mv.setViewName("airplane/airplanemain");
		return mv;
		
	}
	
	@RequestMapping("/Search")
	@ResponseBody
	public ModelAndView search( @RequestParam Map<String, String> params ) {
		
		// 1. airplanemain.jsp 에서 선택한 항공권 조건 value 값 받기 
		String depCity = params.get("depCity");
	    String ariCity = params.get("ariCity");
	    String depDate = params.get("depDate");
	    String arrdate = params.get("arrdate");
	    String initform = params.get("initform");
	    String seatClass = params.get("seatClass");

	    String adultCountStr = params.get("adultCount");
	    int adultCount = Integer.parseInt(adultCountStr);
	    String childCountStr = params.get("childCount");
	    int childCount = Integer.parseInt(childCountStr);
	    String infantCountStr = params.get("infantCount");
	    int infantCount = Integer.parseInt(infantCountStr);
	    
	    System.out.println("=======params: " + params);
		System.out.println("=======depCity: " + depCity);
		System.out.println("=======ariCity: " + ariCity);
		System.out.println("=======depDate: " + depDate);
		System.out.println("=======arrdate: " + arrdate);
		System.out.println("=======initform: " + initform);
		System.out.println("=======seatClass: " + seatClass);
		System.out.println("=======adultCount: " + adultCount);
		System.out.println("=======childCount: " + childCount);
		System.out.println("=======infantCount: " + infantCount);
		
		// 2. 넘어온 value 값 기준 DB 조회
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("depCity", depCity);
		mv.addObject("ariCity", ariCity);
		mv.addObject("depDate", depDate);
		mv.addObject("arrdate", arrdate);
		mv.addObject("initform", initform);
		mv.addObject("seatClass", seatClass);
		mv.addObject("adultCount", adultCount);
		mv.addObject("childCount", childCount);
		mv.addObject("infantCount", infantCount);
		mv.setViewName("airplane/airplanesearch");
		return mv;
		
	}
	
}
