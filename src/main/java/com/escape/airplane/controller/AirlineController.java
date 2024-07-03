package com.escape.airplane.controller;

import com.escape.airplane.domain.AirplaneTimeVo;
import com.escape.airplane.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AirlineController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public List<AirplaneTimeVo> getFlights(@RequestParam String depDate,
                                           @RequestParam String arrDate,
                                           @RequestParam String depCity1,
                                           @RequestParam String arrCity1,
                                           @RequestParam int stype,
                                           @RequestParam List<Integer> ptypeList,
                                           @RequestParam(required = false) List<Map<String, String>> departureTimes) {
        if (departureTimes == null) {
            departureTimes = new ArrayList<>();
        }
        return flightService.getFilteredFlights(depDate, arrDate, depCity1, arrCity1, stype, ptypeList, departureTimes);
    }
}
