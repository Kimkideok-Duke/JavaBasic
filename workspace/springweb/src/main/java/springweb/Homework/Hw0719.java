package springweb.Homework;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Hw0719 {
//	2022-07-15
//	오전 정리문제
//	[1단계:개념] 1. 파일을 업로드 하기 위하여 스프링에 어떤 환경 처리가 필요한가?
            // 뷰(jsp)
            //     - <form emctype="multipart/form-data"
            //         <input type="file" name="report"
            // controller
            //     - 요청 객체로 파일을 받기 : publi String insertBoard(Board ins, Model d)
            //         class Board{
            //             // 추가 property 설정
            //             private MultipartFile mpf;
            //         }
            // - 단일 요청 형식으로 파일 받기 @RequestParam("report") MultipartFile mpf
            // service
            // - MultipartFile tranferTo()를 통해서 선언될 File객체로 변환하여,
            //     특정 위치에 파일명으로 저장
            
				
//	[1단계:확인] 2. 아래와 같은 url을 이용하여 파일을 업로드 처리하세요
//	             /fileUpload05.do    name="file01"    webapp/z05_upload
	// http://localhost:5080/springweb/uploadForm02.do
	@GetMapping("fileUpload05.do")
	public String fileUpload05() {
		return "WEB-INF/views/a02_mvc/a11_fileUpload.jsp";
	}
	@PostMapping("fileUpload05.do")
	public String fileUpload06(@RequestParam("file01") MultipartFile file01) {
		System.out.println("업로드된 파일명:"+file01.getOriginalFilename());
		String fname = file01.getOriginalFilename();
		String path = "/Users/kideokkim/a01_javaexp/workspace/springweb/src/main/webapp/z05_upload/";
		File f = new File(path+fname);
		try {
			file01.transferTo(f);
			System.out.println("파일 업로드 완료");
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return "WEB-INF/views/a02_mvc/a11_fileUpload.jsp";
	}
	

//	[1단계:개념] 3. 파일 업로드와 함께 DB 처리하는 방식을 기술하세요.
            // Dao를 통한 파일 정보 처리
            // - 저장할 파일 정보를 처리한 테이블 구성
            // - 위에 있는 파일명과 경로명, 등록일 등으로 DB할당 처리한다.
            // - dao, mapper 처리
            // table : 
            //     create table boardfile(
            //         no number,
            //         path varchar2(100),
            //         fname varchar2(100),
            //         regdte date,
            //         update date,
            //         etc varchar2(200)
            //     );
                
            //     sql :
            //         insert into boardfile values(board_seq.currval,
            //             #{path}, #{fname}, sysdate, sysdate, '');
            //     vo
            //         class BoardFile{
            //             private int no;
            //             private String path;
            //             private String fname;
            //             private Date regdte;
            //             private Date uptdte;
            //             private String etc;
            //         }
            //     공통 mybatis.		BoardFile boardfile
            //     dao public void insertFile(BoardFile file);
            //     mapper
            //         <insert id="" parameterType="boardfile">
            //             insert into boardfile values(board_seq.currval,
            //             #{path}, #{fname}, sysdate, sysdate, '')
            //         </insert>

            
//	[1단계:확인] 4. 아래와 같은 화면에서 파일 업로드 처리와 DB 등록까지 하세요.
//	            첨부파일:[    ] 게시물명:[   ]
	/*
	1) 초기 기본화면 로딩
        controller
            /fileUpload06.do
            z10_homework\0719.jsp
    2) 화면 구현(z10_homework\0719.jsp)
        <form enctype="multipart/form-data"
            <input type="file" name="addFile"
            <input type="text" name="title"
    3) controller 전송 데이터 처리
        - 매개변수 받는 객체
            class FileVo{
                private MultipartFile addFile;
                private String title;
            }
        - public String upload(FileVo vo, Model d){
            // service처리

            // 메시지
            d.addAttribute("msg",vo.addFile.getOriginalFilename()+"파일첨부성공");
        }
    4) service 처리
        @Value("${upload}")
        private String path;
        public void upload(FileVo vo){
            MultipartFile mpf = vo.getAddFile();
            String fname = mpf.getOriginalFilename();
            File f01 = new File(path+fname);

            mpf.transferTo(f01);

            // DB로 파일 정보 등록
            dao.insetFile(new BoardFile(path,fname))
        }
    5) 파일 정보 등록 처리
        board에 있는 내용을 처리
        vo : springweb.z01_vo.BoardFile
        dao
            springweb.a02_mvc.DaoExp
            public void insertFile(BoardFile file);
        mapper
        	INSERT INTO BOARDFILE values(board_seq.nextval, #{path}, #{fname}, sysdate, sysdate, '')
        */
        
}
