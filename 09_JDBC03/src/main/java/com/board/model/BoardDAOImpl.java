package com.board.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<BoardDTO> getBoardList() {
		
		List<BoardDTO> list = null;
		
		return list = this.template.query("SELECT * FROM BOARD ORDER BY BOARD_NO DESC", new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_content"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_update(rs.getString("board_update"));
				
				return dto;
			}
		});
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		
		int count = this.template.queryForObject("SELECT MAX(BOARD_NO) FROM BOARD", Integer.class);
		
		return this.template.update("INSERT INTO BOARD VALUES(?, ?, ?, ?, ?, DEFAULT, SYSDATE, '')",
				count + 1, dto.getBoard_writer(), dto.getBoard_title(), dto.getBoard_cont(), dto.getBoard_pwd());
		
	}

	@Override
	public BoardDTO boardCont(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readCount(int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSequence(int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardDTO> searchList(String field, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
