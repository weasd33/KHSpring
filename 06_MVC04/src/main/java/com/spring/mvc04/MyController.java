package com.spring.mvc04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping("/join_ok")
	public String joinOk(Person person, Model model) {
		
//		String name = request.getParameter("name");
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		int age = Integer.parseInt(request.getParameter("age"));
//		String phone = request.getParameter("phone");
//		String email = request.getParameter("email");
//		String addr = request.getParameter("addr");
		
//		model.addAttribute("name", name);
//		model.addAttribute("id", id);
//		model.addAttribute("pwd", pwd);
//		model.addAttribute("age", age);
//		model.addAttribute("phone", phone);
//		model.addAttribute("email", email);
//		model.addAttribute("addr", addr);
		
		model.addAttribute("dto", person);
		
		return "joinInfo";
	}
}
