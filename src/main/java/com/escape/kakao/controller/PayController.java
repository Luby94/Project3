package com.escape.kakao.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jq")
public class PayController {

	@PostMapping("/kakaopay.cls")
	@ResponseBody
	public String kakaopay() {
		
		try {
			
			URL url = new URL("open-api.kakaopay.com//online/v1/payment/ready");
			HttpsURLConnection serverconnection = (HttpsURLConnection) url.openConnection();
			serverconnection.setRequestMethod("POST");
			serverconnection.setRequestProperty("Authorization", "DEV8C0CDB31375C6CB3B0723379D6E30663A3530");
			serverconnection.setRequestProperty("Content-Type", "application/json");
			serverconnection.setDoOutput(true);
			String parameter = "cid=TC0ONETIME";
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return "";
		
	}
	
}
