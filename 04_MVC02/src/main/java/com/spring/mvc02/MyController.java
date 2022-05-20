package com.spring.mvc02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@RequestMapping("/input")
	public String abc() {
		return "insertForm";
	}
	
	@RequestMapping("/inputOk")
	public String aaa(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		
		return "loginResult";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping("/loginOk")
	public String loginOk(@RequestParam("userId") String id, @RequestParam("userPwd") String pwd, Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		
		return "loginResult";
	}
	
}
