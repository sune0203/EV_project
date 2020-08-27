package com.ev.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ev.api.EvApi;
import com.ev.service.ApiService;
import com.ev.vo.ApiVO;

@Controller
@RequestMapping("/api/*")
public class ApiController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Inject
	ApiService service;
	
	@RequestMapping(value = "/up", method = RequestMethod.GET)
	public String api(EvApi api) throws Exception {
		logger.info("Welcome home! The client locale is {}.");
		
			service.delete();
			service.inc();
			List<ApiVO> list = api.api();
			
			for(ApiVO vo : list) {	
			service.insert(vo);
			}
		
		return "home";
	}
	
}
