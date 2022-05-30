package com.board.mybatis03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("board_write.do")
	public String write() {
		return "board_writeForm";
	}
	
	@RequestMapping("board_write_ok.do")
	public void writeOk(BoardDTO dto, HttpServletResponse response) throws IOException {
		int result = this.dao.insertBoard(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시글 추가 성공!!')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시글 추가 실패..')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("board_content.do")
	public String content(@RequestParam("no") int no, @RequestParam("page") int nowPage, Model model) {
		
		// 조회수 증가
		this.dao.readCount(no);
		
		// 게시글 상세 내역 조회
		BoardDTO dto = this.dao.boardCont(no);
		
		model.addAttribute("Cont", dto);
		model.addAttribute("Page", nowPage);
		
		return "board_content";
	}
	
	@RequestMapping("board_modify.do")
	public String modify(@RequestParam("no") int no, @RequestParam("page") int nowPage, Model model) {
		
		// 게시글 상세 내역 조회
		BoardDTO dto = this.dao.boardCont(no);
		
		model.addAttribute("Modify", dto);
		model.addAttribute("Page", nowPage);
		
		return "board_modifyForm";
	}
	
	@RequestMapping("board_modify_ok.do")
	public void modifyOk(BoardDTO dto,
			@RequestParam("db_pwd") String db_pwd,
			@RequestParam("page") int nowPage, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(dto.getBoard_pwd().equals(db_pwd)) {
			int result = this.dao.updateBoard(dto);
			
			if (result > 0) {
				out.println("<script>");
				out.println("alert('게시글 수정 성공!!')");
				out.println("location.href='board_content.do?no=" + dto.getBoard_no() + "&page=" + nowPage + "'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시글 수정 실패..')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("board_delete.do")
	public String delete(@RequestParam("no") int no, @RequestParam("page") int nowPage, Model model) {
		
		// 게시글 상세 내역 조회
		BoardDTO dto = this.dao.boardCont(no);
		
		model.addAttribute("delete", dto);
		model.addAttribute("Page", nowPage);
		
		return "board_delete";
	}
	
	@RequestMapping("board_delete_ok.do")
	public void deleteOk(BoardDTO dto,
			@RequestParam("db_pwd") String db_pwd,
			@RequestParam("page") int nowPage, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(dto.getBoard_pwd().equals(db_pwd)) {
			int result = this.dao.deleteBoard(dto.getBoard_no());
			
			if (result > 0) {
				this.dao.updateSequence(dto.getBoard_no());
				out.println("<script>");
				out.println("alert('게시글 삭제 성공!!')");
				out.println("location.href='board_list.do?page=" + nowPage + "'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시글 삭제 실패..')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("board_search.do")
	public String search(@RequestParam("field") String field,
				@RequestParam("keyword") String keyword,
				@RequestParam("page") int nowPage, Model model) {
		
		totalRecord = this.dao.searchBoardCount(field, keyword);
		
		PageDTO dto = new PageDTO(nowPage, rowsize, totalRecord, field, keyword); 
		
		System.out.println("검색 게시물 수 >> " + dto.getTotalRecord());
		System.out.println("검색 전체 페이지 수 >> " + dto.getAllPage());
		
		List<BoardDTO> list = this.dao.searchBoardList(dto);
		
		model.addAttribute("searchPageList", list);
		model.addAttribute("Paging", dto);
		
		return "board_searchList";
	}
}
