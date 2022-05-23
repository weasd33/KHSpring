package com.khie.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
// Spring에서 일반적으로 DAO 클래스에 적용되는 어노테이션 
public class MemberDAOImpl implements MemberDAO {

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
	// MEMBER10 테이블에 회원을 등록하는 메서드
	public int insertMember(final MemberDTO dto) {

		sql = "SELECT MAX(NUM) FROM MEMBER10";

		final int count = this.template.queryForObject("SELECT COUNT(*) FROM MEMBER10", Integer.class);

		sql = "INSERT INTO MEMBER10 VALUES(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

		return this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, count + 1);
				ps.setString(2, dto.getMemid());
				ps.setString(3, dto.getMemname());
				ps.setString(4, dto.getPwd());
				ps.setInt(5, dto.getAge());
				ps.setInt(6, dto.getMileage());
				ps.setString(7, dto.getJob());
				ps.setString(8, dto.getAddr());
			}
		});
	}

	@Override
	public MemberDTO getMember(int num) {

		sql = "SELECT * FROM MEMBER10 WHERE NUM = ?";

		return this.template.queryForObject(sql, new RowMapper<MemberDTO>() {

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
		}, num);

	}

	@Override
	public int updateMember(final MemberDTO dto) {

		sql = "UPDATE MEMBER10 SET AGE = ?, " + "MILEAGE = ?, JOB = ?, " + "ADDR = ? WHERE NUM = ?";

		return this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, dto.getAge());
				ps.setInt(2, dto.getMileage());
				ps.setString(3, dto.getJob());
				ps.setString(4, dto.getAddr());
				ps.setInt(5, dto.getNum());
			}
		});
	}

	@Override
	public int deleteMember(final int num) {

		sql = "DELETE FROM MEMBER10 WHERE NUM = ?";

		return this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, num);
			}
		});
	}

	@Override
	public void updateSequence(final int num) {

		sql = "UPDATE MEMBER10 SET NUM = NUM - 1 WHERE NUM > ?";

		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, num);
			}
		});
	}

	@Override
	public List<MemberDTO> searchMemberList(String field, String keyword) {

		List<MemberDTO> searchList = null;

		if (field.equals("id")) {
			sql = "SELECT * FROM MEMBER10 WHERE MEMID LIKE ? ORDER BY NUM DESC";

			searchList = this.template.query(sql, new RowMapper<MemberDTO>() {

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
			}, "%" + keyword + "%");
		} else if (field.equals("name")) {
			sql = "SELECT * FROM MEMBER10 WHERE MEMNAME LIKE ? ORDER BY NUM DESC";

			searchList = this.template.query(sql, new RowMapper<MemberDTO>() {

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
			}, "%" + keyword + "%");
		} else {
			sql = "SELECT * FROM MEMBER10 WHERE JOB LIKE ? ORDER BY NUM DESC";

			searchList = this.template.query(sql, new RowMapper<MemberDTO>() {

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
			}, "%" + keyword + "%");
		}
		return searchList;
	}

}
