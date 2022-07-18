package board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	@Value("${upload")
	private String path;
	
	public void insertBoard(Board ins) {
		MultipartFile mpf = ins.getReport();
		String fname = mpf.getOriginalFilename();
		
		File f = new File(path+fname);
		try {
			mpf.transferTo(f);
			System.out.println("파일업로드 완성");
		}catch(IllegalStateException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	};
	
	public Board getBoardDetail(int no){
		dao.readCountup(no);
		return dao.getBoardDetail(no);
	}
	public Board updateBoard(Board upt) {
		dao.updateBoard(upt); // 수정과 함께 수정된 상세 데이터
		return dao.getBoardDetail(upt.getNo());
	}
	public void deleteBoard(int no) {
		dao.deleteBoard(no);
	}
}
