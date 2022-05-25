package com.spring.mybatis01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.MemberDAO;
import com.spring.model.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("member_list.do")
	public String list(Model model) {
		List<MemberDTO> list = this.dao.getMemberList();
		
		model.addAttribute("List", list);
		
		return "member_list";
	}
}
