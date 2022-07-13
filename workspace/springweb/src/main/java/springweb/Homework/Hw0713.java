package springweb.Homework;

public class Hw0713 {
//	2022-07-13
//	[1단계:개념] 1. 게시판의 상세화면 처리 프로세스를 기술하고, 각 내용의 핵심 코드를 기술하세요.
                // # 상세화면 로딩
                // 1. sql
                // 	1) select * from board where no = #{no}
                // 	2) update board
                // 		set readcnt = readcnt+1
                // 		where no = #{no}
                // 2. vo 확인
                // 3. dao/mapper : 
                // 	public Board getBoardDetail(int no);
                // 	public void readCountup(int no);
                // 4. service
                // 	public Board getBoardDetail(int no){
                // 		dao.readCountup(no);

                // 		return dao.getBoardDetail(no);
                // 	}
                // 5. view단 상세화면 기본 인터페이스 결정
                // 	리스트 화면에서 특정 row클릭시 get 방식으로 no와 함께 상세화면 controller 호출
                // 	<tr ondbclick="goDetail(${board.no})">
                // 	function goDetail(no){
                // 		location.href="${path}/boardDetail.do?no="+no;
                // 	}
                // 6. controller
                // 	기능 메서드 선언/요청값 처리
                // 	@RequestMapping("boardDetail.do")
                // 	public String boardDetail(@RequestParam("no") int no, Model d){
                // 		d.addAttribute("board", service.getBoardDetail(no));

                // 		return "상세화면 jsp 페이지";
                // 	}
                // 7. view
                // 	<input name="no" value="${board.no}">
                // 	<input name="subject" value="${board.subject}">
                // 	<input name="writer" value="${board.writer}">
                // 	<textarea name="content">${board.content}</textarea>
                // 	<input name="regdte" value="${board.regdte}">
                // 	<input name="uptdte" value="${board.uptdte}">

                //     # 수정 삭제
                //     1. sql 작성
                //         UPDATE board011
                //             SET subject = #{subject},
                //                 content = #{content},
                //                 uptdte = sysdate
                //         WHERE NO = #{no}
                    
                //         DELETE
                //         form board011
                //         WHERE NO = #{no}
                //     2. vo 확인 : board
                //     3. dao 기능메서드
                //         public void updateBoard(Board upt);
                //         public void deleteBoard(int no);
                //     4. mapper 추가
                //         <update id="updateBoard" parameterType="board">
                //             UPDATE board011
                //                 SET subject = #{subject},
                //                     content = #{content},
                //                     uptdte = sysdate
                //             WHERE NO = #{no}
                //         </update>
                //         <delete id="deleteBoard" parameterType="int">
                //             DELETE
                //             form board011
                //             WHERE NO = #{no}
                //         </delete>
                //     5. service 기능 추가.
                //     6. 뷰(jsp)수정 처리 ui
                //         수정버튼 : <Button type="button" onclick="updateProc()">수정</Button>
                //         삭제버튼 : <Button type="button" onclick="deleteProct()">삭제</Button>
                //         답글버튼 : <Button type="button" onclick="replyProc()">답글</Button>
                //         function updateProc(){
                //             if(confirm("수정하시겠습니끼?")){
                //                 // 유효성 check
                //                 $("form").attr("action","${path}/boardUpdate.do");
                //                 $("form").submit();
                //             }
                //         }
                //         function deleteProct(){
                //             if(confirm("삭제하시겠습니까?")){
                //                 $("form").attr("action","${path}/boardDelete.do");
                //                 $("form").submit();
                //             }
                //         }
                //         function replyProc(){
                    
                //         }
                //     7. 수정 처리 controller
                //         @RequestMapping("updateBoard.do")
                //         public String updateBoard(Board upt, Model d) {
                //             System.out.println("수정:"+upt.getSubject());
                //             d.addAttribute("board",service.updateBoard(upt));
                //             d.addAttribute("proc","upt");
                //             return "WEB-INF/views/a03_boardDetail.jsp";
                //         }
                //         @RequestMapping("deleteBoard.do")
                //         public String deleteBoard(@RequestParam("no") int no, Model d) {
                //             System.out.println("삭제:"+no);
                //             d.addAttribute("proc","del");
                //             return "WEB-INF/views/a03_boardDetail.jsp";
                //         }
                //         service
                //         public Board updateBoard(Board upt){
                //             dao.updateBoard(upt);
                //             return dao.detailBoard(upt.getEmpno());
                //         }
                //     8. 뷰(jsp) 수정 처리후 처리
                //         js
                //         var proc = "${proc}"
                //         if(proc=="upt"){
                //             if(confirm("수정성공\n조회리스트 화면으로 이동하시겠습니까?")){
                //                 location.href="${path}/boardList.do";
                //             }
                //         }
                //         if(proc=="del"){
                //             alert("삭제성공\n조회 리스트화면으로 이동")
                //             location.href="${path}/boardList.do";
                //         }

//	[1단계:개념] 2. 게시판의 수정/삭제를 구분하는 js 코드는 무엇인가?
                // var proc = "${proc}"
                // if(proc=="upt"){
                // 	if(confirm("수정성공\n조회리스트 화면으로 이동하시겠습니까?")){
                // 		location.href="${path}/boardList.do";
                // 	}
                // }
                // if(proc=="del"){
                // 	alert("삭제성공\n조회 리스트화면으로 이동")
                // 	location.href="${path}/boardList.do";
                // }

//	[1단계:확인] 3. 오늘한 게시판 상세조회에서 수정삭제와 같이 사원리스트 기준으로 
//	      기존 dao(DaoExp01)를 이용하여 spring에서 상세조회수정삭제하세요.
//	      public Emp getDetail(int empno);
//	      public void updateEmp02(Emp upt);
//	      (추가)public void deleteEmp(int empno);
}
