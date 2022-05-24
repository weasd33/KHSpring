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
	
	@Override
	public List<ProductDTO> getProductList() {
		
		List<ProductDTO> list = null; 
		
		return list = this.template.query("SELECT * FROM PRODUCT ORDER BY PNO DESC", new RowMapper<ProductDTO>() {
			
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
		
		String cName = null;
		
		if(dto.getCno() == 1) {
			cName = "프로그래밍";
		} else if (dto.getCno() == 2) {
			cName = "요리";
		} else if (dto.getCno() == 3) {
			cName = "경제";
		} else if (dto.getCno() == 4) {
			cName = "건강";
		} else {
			cName = null;
		}
		
		int count = this.template.queryForObject("SELECT MAX(PNO) FROM PRODUCT WHERE CNO = ?", Integer.class, dto.getCno());

		return this.template.update("INSERT INTO PRODUCT VALUES(?, ?, ?, ?, ?, ?, ?)", 
				count + 1, dto.getPname(), dto.getStock(), dto.getPrice(), dto.getCompany(), dto.getCno(), cName);
	}

	@Override
	public ProductDTO getProductCont(int pno) {
		
		return this.template.queryForObject("SELECT * FROM PRODUCT WHERE PNO = ?", new RowMapper<ProductDTO>() {
			
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
		}, pno);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		
		this.template.update("UPDATE PRODUCT SET "
				+ "PNAME = ?, STOCK = ?, PRICE = ?, COMPANY = ? WHERE PNO = ?",
				dto.getPname(), dto.getStock(), dto.getPrice(), dto.getCompany(), dto.getPno());
	}

	@Override
	public void deleteProduct(int pno) {
		
		this.template.update("DELETE FROM PRODUCT WHERE PNO = ?", pno);
	}

	@Override
	public void updateSeq(int pno, int cno) {
		
		this.template.update("UPDATE PRODUCT SET PNO = PNO - 1 WHERE CNO = ? AND PNO > ?", cno, pno);
		
	}

	@Override
	public List<ProductDTO> searchProduct(String field, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
