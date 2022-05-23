package com.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private JdbcTemplate template;
	
	String sql = null;
	
	@Override
	public List<ProductDTO> getProductList() {
		
		List<ProductDTO> list = null; 
		
		sql = "SELECT * FROM PRODUCT ORDER BY PNO DESC";
		
		return list = this.template.query(sql, new RowMapper<ProductDTO>() {
			@Override
			public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductDTO dto = new ProductDTO();
				dto.setPno(rs.getInt("PNO"));
				dto.setPname(rs.getString("PNAME"));
				dto.setStock(rs.getInt("STOCK"));
				dto.setPrice(rs.getInt("PRICE"));
				dto.setCompany(rs.getString("COMPANY"));
				dto.setCno(rs.getInt("CNO"));
				dto.setCname(rs.getString("CNAME"));
				
				return dto;
			}
		});
	}

	@Override
	public int insertProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDTO getProductCont(int pno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int pno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSeq(int pno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> searchProduct(String field, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> categoryList() {
		// TODO Auto-generated method stub
		return null;
	}

}
