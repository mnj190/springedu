package com.kh.portpolio.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/req")
public class RequestController {

	private static Logger logger = LoggerFactory.getLogger(RequestController.class);

	// 1)HttpRequest 객체 이용
	@GetMapping("/1")
	public void req1(HttpServletRequest req) {
		logger.info("void req1()호출됨");

		String name = req.getParameter("name");
		String age = req.getParameter("age");

		logger.info("name = " + name);
		logger.info("age = " + age);
	}

	// 2)@RequestParam 사용
	@GetMapping("/2")
	public void req2(@RequestParam("name") String name, @RequestParam("age") int age) {
		logger.info("void req2() 호출됨");

		logger.info("name = " + name);
		logger.info("age = " + age);
	}

	@GetMapping("/3")
	public void req3(@RequestParam Map<String, String> map) {
		logger.info("void req2() 호출됨");

		logger.info("name = " + map.get("name"));
		logger.info("age = " + map.get("age"));
	}

	// 3) 사용자 정의 클래스에 바인딩
	@GetMapping("/4")
	public void req4(Person person) {
		logger.info("void req2() 호출됨");

		logger.info("name = " + person.getName());
		logger.info("age = " + person.getAge());
	}

	// 4) 복수의 요청 URL에 대해 하나의 메소드에서 처리하고자 할 때
	@GetMapping(value = { "/5", "/6", "7" })
	public void req5() { // 반환 타입이 void인 경우 view이름이 요청 URl의 마지막 문ㄴ자열이 된다.
		logger.info("req5() 호출됨");
	}

	// --서버 응답 1.forward 2.redirect
	@GetMapping("/8")
	public String req6(Model model) {
		model.addAttribute("key", "value");
//		return "req/7";
//		return "forward:/req/7";
//		return "redirect:/req/7";
		return "forward:http://www.naver.com";
	}

	@GetMapping("/9")
	public String req7(Model model, RedirectAttributes redirectAttrs) {

		model.addAttribute("key", "value");
		redirectAttrs.addFlashAttribute("key", "value");
		return "redirect:/req/7";
	}

	// url 경로명을 파리미터로 사용하고자 할 때 (주로 Restfull 서비스 구현시 사용)
	@GetMapping("/10/{name}/{age}")
	public String req8(@PathVariable("name") String name, @PathVariable("age") String age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);

		return "test";
	}

	// ModelAndView 사용
	@GetMapping("/11/{name}/{age}")
	public ModelAndView req9(
			@PathVariable("name") String name,
			@PathVariable("age") String age) {
		
		ModelAndView mav = new ModelAndView();
		
		//부정보
		mav.setViewName("test");
		//모델정보
		mav.addObject("name" , name);
		mav.addObject("age", age);
		
		return mav;				
	}
}
