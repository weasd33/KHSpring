package com.spring.jdbc02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.ProductDAO;
import com.spring.model.ProductDTO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	@RequestMapping("error.do")
	public String error() {
		return "error";
	}
	
	@RequestMapping("product_list.do")
	public String list(Model model) {
		
		List<ProductDTO> list = this.dao.getProductList();
		
		model.addAttribute("list", list);
		
		return "product_list";
	}
	
	@RequestMapping("product_insert.do")
	public String insert() {
		
		return "product_insert";
	}
	
	@RequestMapping("product_insert_ok.do")
	public void insertOk(ProductDTO dto, HttpServletResponse response) throws IOException {
		
		int result = this.dao.insertProduct(dto);
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('Insert Success!!')");
			out.println("location.href='product_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("location.href='error.do'");
			out.println("</script>");
		}
	}
	
	@RequestMapping("product_content.do")
	public String content(@RequestParam("num") int num, Model model) {
		ProductDTO dto = this.dao.getProductCont(num);
		
		model.addAttribute("Cont", dto);
		
		return "product_content";
	}
	
	@RequestMapping("product_modify.do")
	public String modify(@RequestParam("num") int num, Model model) {
		ProductDTO dto = this.dao.getProductCont(num);
		
		model.addAttribute("Modify", dto);
		
		return "product_modify";
	}
	
	@RequestMapping("product_modify_ok.do")
	public String modifyOk(ProductDTO dto, Model model) {
		this.dao.updateProduct(dto);
		
		ProductDTO cont = this.dao.getProductCont(dto.getPno());
		
		model.addAttribute("Cont", cont);
		
		return "product_content";
	}
	
	@RequestMapping("product_delete.do")
	public String delete(@RequestParam("num") int num, @RequestParam("cno") int cno, Model model) {
		
		this.dao.deleteProduct(num);
		this.dao.updateSeq(num, cno);
		
		List<ProductDTO> list = this.dao.getProductList();
		
		model.addAttribute("list", list);
		
		return "product_list";
	}
}












