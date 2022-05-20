package com.khie.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
// Spring에서 일반적으로 DAO 클래스에 적용되는 어노테이션 
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	// 자동으로 의존관계를 설정해 주는 어노테이션
	// 무조건 객체에 대한 의존을 주입해 주는 어노테이션
	private JdbcTemplate template;
	
	String sql = "null";
	
	@Override
	// 전체 회원 목록 조회
	public List<MemberDTO> getMemberList() {
		
		List<MemberDTO> list = null;
		
		sql = "SELECT * FROM MEMBER10 ORDER BY NUM DESC";
		
		return list = this.template.query(sql, new RowMapper<MemberDTO>() {

			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt("num"));
				dto.setMemid(rs.getString("memid"));
				dto.setMemname(rs.getString("memname"));
				dto.setPwd(rs.getString("pwd"));
				dto.setAge(rs.getInt("age"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setJob(rs.getString("job"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			}
		}); 
	}

	@Override
	public int insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO getMember(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSequence(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberDTO> searchMemberList(String field, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
