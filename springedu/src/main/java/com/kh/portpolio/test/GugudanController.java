package com.kh.portpolio.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gugu")
public class GugudanController {
	private static Logger logger = LoggerFactory.getLogger(CalculatorController.class);

	@GetMapping("/view")
	public String view() {
		logger.info("view 페이지 호출");
		return "gugudan";
	}

	@GetMapping("/result")
	public String result(HttpServletRequest req, Model model) {
		logger.info("result 페이지 호출");

		try {
			int num = Integer.parseInt(req.getParameter("number"));
			String x = "";

			for (int i = 1; i <= 9; i++) {
				x += num + "*" + i + "=" + num * i;
				x += "<br>";
			}

			model.addAttribute("result", x);
		} catch (Exception e) {
			model.addAttribute("result", "값을 입력해주세요.");
		}

		return "gugudan";
	}

	@GetMapping("/view2")
	public String view2() {
		logger.info("view2 페이지 호출");
		return "gugudan2";
	}

	@GetMapping("/result2")
	public String result2(@RequestParam int number, Model model) {
		logger.info("result2 페이지 호출");

		try {			
			String x = "";

			for (int i = 1; i <= 9; i++) {
				x += number + "*" + i + "=" + number * i;
				x += "<br>";
			}

			model.addAttribute("result", x);
		} catch (Exception e) {
			model.addAttribute("result", "값을 입력해주세요.");
		}

		return "gugudan2";
	}
	
	//구구단 화면
	@GetMapping("/gugudanForm")
	public String gugudanForm() {
		logger.info("view3 페이지 호출");
		return "gugudanForm";
	}

	//구구단 처리
	@PostMapping("")	//요청 파라미터 이름과 지역변수 명이 값으면 매개값 생략 가능 == @RequestParam("dansu") String dansu
	public String gugudan(
			@RequestParam String dansu, Model model
			) {
		logger.info("result3 페이지 호출");
		
		model.addAttribute("dansu", dansu);		
	
		return "gugudanForm";
	}
	
}
