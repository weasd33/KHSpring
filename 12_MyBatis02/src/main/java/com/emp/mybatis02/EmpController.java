package com.emp.mybatis02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.model.DeptDTO;
import com.emp.model.EmpDAO;
import com.emp.model.EmpDTO;

@Controller
public class EmpController {
	
	@Autowired
	private EmpDAO dao;
	
	@RequestMapping("emp_list.do")
	public String list(Model model) {
		
		List<EmpDTO> list = this.dao.getEmpList();
		
		model.addAttribute("List", list);
		
		return "emp_list";
	}
	
	@RequestMapping("emp_insert.do")
	public String insert(Model model) {
		// 담당업무 조회
		List<String> jobList = this.dao.getJobList();
		
		// 관리자 조회
		List<EmpDTO> mgrList = this.dao.getMgrList();
		
		// 부서번호 조회
		List<DeptDTO> deptList = this.dao.getDeptList();
		
		model.addAttribute("JobList", jobList);
		model.addAttribute("MgrList", mgrList);
		model.addAttribute("DeptList", deptList);
		
		return "emp_insert";
	}
	
	@RequestMapping("emp_insert_ok.do")
	public void insertOk(EmpDTO dto, HttpServletResponse response) throws IOException {
		int result = this.dao.insertEmp(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('사원 등록 성공!!')");
			out.println("location.href='emp_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('사원 등록 실패..')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("emp_content.do")
	public String cont(@RequestParam("no") int empno, Model model) {
		EmpDTO dto = this.dao.getEmp(empno);
		
		List<DeptDTO> deptList = this.dao.getDeptList();
		
		model.addAttribute("Cont", dto);
		model.addAttribute("DeptList", deptList);
		
		return "emp_content";
	}
	
	@RequestMapping("emp_update.do")
	public String modify(@RequestParam("no") int empno, Model model) {
		
		// 담당업무 조회
		List<String> jobList = this.dao.getJobList();
		
		// 관리자 조회
		List<EmpDTO> mgrList = this.dao.getMgrList();
		
		// 부서번호 조회
		List<DeptDTO> deptList = this.dao.getDeptList();
		
		EmpDTO dto = this.dao.getEmp(empno);
		
		model.addAttribute("JobList", jobList);
		model.addAttribute("MgrList", mgrList);
		model.addAttribute("DeptList", deptList);
		model.addAttribute("modify", dto);
		
		return "emp_update";
	}
	
	@RequestMapping("emp_modify_ok.do")
	public void modifyOk(EmpDTO dto, HttpServletResponse response) throws IOException {
		
		int result = this.dao.updateEmp(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('사원 수정 성공!!')");
			out.println("location.href='emp_content.do?no=" + dto.getEmpno() + "'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('사원 수정 실패..')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}














