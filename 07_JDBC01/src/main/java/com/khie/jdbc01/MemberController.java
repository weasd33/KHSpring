package com.khie.jdbc01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khie.model.MemberDAO;
import com.khie.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
		
	@RequestMapping("member_list.do")
	public String list(Model model) {
		
		List<MemberDTO> list = this.dao.getMemberList();
		model.addAttribute("list", list);
		
		return "member_list";
	}
	
	@RequestMapping("member_insert.do")
	public String insert() {
		return "member_insert";
	}

	@RequestMapping("member_insert_ok.do")
	public void insertOk(MemberDTO dto, HttpServletResponse response) throws IOException {
		int check = this.dao.insertMember(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			out.println("<script>");
			out.println("alert('회원 등록 성공!!')");
			out.println("location.href='member_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('회원 등록 실패..')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
