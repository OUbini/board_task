package com.task.ou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {
	
	//로그인페이지 이동
	@GetMapping("/loginForm")
	public ModelAndView loginForm(ModelAndView view) {
		log.info("loginForm()..");
		
		view.setViewName("/loginForm");
		return view;
	}


}
