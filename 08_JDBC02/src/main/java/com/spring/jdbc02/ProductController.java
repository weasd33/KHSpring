package com.spring.jdbc02;

import java.util.List;

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
	
	@RequestMapping("product_list.do")
	public String list(Model model) {
		
		List<ProductDTO> list = this.dao.getProductList();
		model.addAttribute("list", list);
		
		return "product_list";
	}
	
}
