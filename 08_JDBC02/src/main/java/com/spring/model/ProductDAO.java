package com.spring.model;

import java.util.List;

public interface ProductDAO {

	List<ProductDTO> getProductList();
	int insertProduct(ProductDTO dto);
	ProductDTO getProductCont(int pno);
	void updateProduct(ProductDTO dto);
	void deleteProduct(int pno);
	void updateSeq(int pno, int cno);
	List<ProductDTO> searchProduct(String field, String keyword);
}
