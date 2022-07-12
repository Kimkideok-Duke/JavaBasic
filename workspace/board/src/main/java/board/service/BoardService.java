package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDao;
import board.vo.Board;

@Service
public class BoardService {
	@Autowired(required=false)
	private BoardDao dao;
	
	public List<Board> boardList(Board sch){
		// 요청값을 넘기고, 객체(ArrayList<Board>)를 받는 처리.
		return dao.boardList(sch);
	}
	
	public void insertBoard(Board ins) {
		dao.insertBoard(ins);
	};
}
