package com.spring.jdbc02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}












