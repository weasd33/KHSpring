package com.board.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getListCount() {
		return this.sqlSession.selectOne("count");
	}

	@Override
	public List<BoardDTO> getBoardList(PageDTO dto) {
		return this.sqlSession.selectList("list", dto);
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void readCount(int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardDTO boardCont(int no) {
		// TODO Auto-generated method stub
		return null;
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
	public int searchBoardCount(String field, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> searchBoardList(PageDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
