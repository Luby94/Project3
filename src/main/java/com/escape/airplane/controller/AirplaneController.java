package com.escape.airplane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Airplane")
public class AirplaneController {

	@RequestMapping("/Main")
	public ModelAndView main() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("airplane/airplanemain");
		return mv;
		
	}
	
}
