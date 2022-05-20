package com.spring.mvc03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/input")
	public String grade() {
		return "grade";
	}
	
	@RequestMapping("/inputOk")
	public String gradeOk(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name"); 
		String kor = request.getParameter("kor"); 
		String eng = request.getParameter("eng"); 
		String math = request.getParameter("math");
		
		model.addAttribute("name", name);
		model.addAttribute("kor", kor);
		model.addAttribute("eng", eng);
		model.addAttribute("math", math);
				
		return "gradeOk";
	}
}
