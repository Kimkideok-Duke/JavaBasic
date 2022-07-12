package board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import board.vo.Board;
// board.dao.BoardDao
@Repository
public interface BoardDao {
	public List<Board> boardList(Board sch);
	
	public void insertBoard(Board ins);
}
