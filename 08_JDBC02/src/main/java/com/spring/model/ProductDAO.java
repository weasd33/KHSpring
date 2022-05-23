package com.spring.model;

import java.util.List;

public interface ProductDAO {

	List<ProductDTO> getProductList();
	int insertProduct(ProductDTO dto);
	ProductDTO getProductCont(int pno);
	int updateProduct(ProductDTO dto);
	int deleteProduct(int pno);
	void updateSeq(int pno);
	List<ProductDTO> searchProduct(String field, String keyword);
	List<CategoryDTO> categoryList();
}
