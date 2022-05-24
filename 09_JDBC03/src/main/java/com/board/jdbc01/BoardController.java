package com.board.jdbc01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("error.do")
	public String error() { 
		return "error";
	}
	
	@RequestMapping("board_list.do")
	public String list(Model model) {
		List<BoardDTO> list = this.dao.getBoardList();
		
		model.addAttribute("List", list);
		
		return "board_list";
	}
	
	@RequestMapping("board_write.do")
	public String write() {
		return "board_write";
	}
	
	@RequestMapping("board_write_ok.do")
	public String writeOk(BoardDTO dto) {
		this.dao.insertBoard(dto);
		
		return "redirect:board_list.do";
	}
	
	@RequestMapping("board_content.do")
	public String content(@RequestParam("no") int no, Model model) {
		// 조회수 증가
		this.dao.readCount(no);
		// 상세내용
		BoardDTO dto = this.dao.boardCont(no);
		
		model.addAttribute("Cont", dto);
		
		return "board_content";
	}
}


