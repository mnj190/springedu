package com.kh.portpolio.test;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller	//컨트롤러로 등록
@RequestMapping(value = "/test")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@GetMapping("/1")
	public String test(Model model) {
		logger.info("public String test1() 요청됨");

		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 30);
		return "test";
	}

	@GetMapping("/2")
	public String test2(Model model) {
		logger.info("public String test2() 요청됨");

		model.addAttribute("name", "손오공");
		model.addAttribute("age", 20);
		return "test";
	}

	@GetMapping(value = {"/3","/4","/5"})
	public String test3(Model model) {
		HttpHeaders headers = new HttpHeaders();
		logger.info("public String test3() 요청됨");
		logger.info(headers.getVary().toString());
		return "test";
	}
	
	@RequestMapping(value="/6", method = RequestMethod.POST)
	public String test4() {
		logger.info("public String test4() 요청됨");
		return "test";
	}
	
	@GetMapping("/7")
	public String test5() {
		logger.info("public Stirng test5() 요청됨");
		return "redirect:http://www.naver.com";
	}
	
	@GetMapping("/8")
	public void test6(HttpServletRequest request) {
		logger.info("public Stirng test6() 요청됨");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		logger.info(name+" : "+age);
	}
}
