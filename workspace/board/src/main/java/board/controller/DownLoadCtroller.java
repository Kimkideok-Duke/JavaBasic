package board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownLoadCtroller {
	// http://localhost:5080/board/download.do?fname=5c32e1ee5bc195dde5c4715d85e7babe.jpg
	@RequestMapping("download.do")
	public String download(@RequestParam("fname") String fname, Model d) {
		d.addAttribute("downloadFileName", fname);
		// viewer에서 지정한 모델명으로 파일명을 지정
		// viewer
		// String fname = (String)model.get("downloadFileName");
		
		return "downloadViewer";
	}
}
