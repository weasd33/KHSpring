package com.board.mybatis03;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;
import com.board.model.PageDTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	private final int rowsize = 3;	// 한 페이지당 보여질 게시물 수
	private int totalRecord = 0;	// DB 상의 전체 게시물의 수
	
	@RequestMapping("board_list.do")
	public String list(HttpServletRequest request, Model model) {
		
		int page;	// 현재 페이지
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		} else {
			page = 1;	// 처음으로 게시물 전체 목록 태그를 선택했을 경우
		}
		
		// DB 상의 전체 게시물의 수
		totalRecord = this.dao.getListCount();
		
		PageDTO dto = new PageDTO(page, rowsize, totalRecord);
		
		// 페이지에 해당하는 게시물을 가져오는 메서드
		List<BoardDTO> list = this.dao.getBoardList(dto);
		
		model.addAttribute("List", list);
		model.addAttribute("Paging", dto);
		
		return "board_list";
	}
}
