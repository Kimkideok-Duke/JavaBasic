package springweb.Homework;

import a01_diexp.z06_vo.Dao;

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
/*
dao
    public List<Emp> getEmp01List();
    public Emp getDetail(int empno);
    public void updateEmp01(Emp upt);
    public void deleteEmp(int empno);

mapper
    <select id="getEmp01List" resultType="emp">
        SELECT * FROM emp01
    </select>
    <select id="getDetail" resultType="emp" parameterType="int">
        SELECT * FROM emp01
        WHERE empno = #{empno}
    </select>
    <update id="updateEmp01" parameterType="emp">
    UPDATE EMP01
        SET ename = #{ename},
            job = #{job},
            mgr = #{mgr},
            sal = #{sal},
            comm = #{comm},
            deptno = #{deptno}
    WHERE empno = #{empno}
    </update>
    <delete id="deleteEmp" parameterType="int">
        DELETE
        FROM EMP01
        WHERE empno = #{empno}
    </delete>

service
    public List<Emp> getEmp01List(){
        return dao2.getEmp01List();
    }
    public Emp getDetail(int empno) {
        return dao2.getDetail(empno);
    }
    public Emp updateEmp01(Emp upt) {
        dao2.updateEmp01(upt);
        return dao2.getDetail(upt.getEmpno());
    }
    public void deleteEmp(int empno) {
        dao2.deleteEmp(empno);
    }

controller
    @RequestMapping("getEmp01List.do")
    public String getEmp01List(Model d) {
        d.addAttribute("elist", service.getEmp01List());
        return "WEB-INF/views/a02_mvc/Hw0713_emp01List.jsp";
    }
    @RequestMapping("getDetail.do")
    public String getDetail(@RequestParam("empno") int empno, Model d) {
        d.addAttribute("emp", service.getDetail(empno));
        return "WEB-INF/views/a02_mvc/Hw0713_empDetail.jsp";
    }
    @RequestMapping("updateEmp01.do")
    public String updateEmp01(Emp upt, Model d) {
        d.addAttribute("emp", service.updateEmp01(upt));
        d.addAttribute("proc", "upt");
        return "WEB-INF/views/a02_mvc/Hw0713_empDetail.jsp";
    }
    @RequestMapping("deleteEmp.do")
    public String deleteEmp(@RequestParam("empno") int empno, Model d) {
        service.deleteEmp(empno);
        d.addAttribute("proc", "del");
        return "WEB-INF/views/a02_mvc/Hw0713_empDetail.jsp";
    }

view
empList 
    js
    function goDetail(empno){
        location.href="${path}/getDetail.do?empno="+empno;
    }

    <tr class="table-success text-center">
        <th>사원번호</th>
        <th>사원명</th>
        <th>직책명</th>
        <th>급여</th>
        <th>부서번호</th>
    </tr> 
    <c:forEach var="emp" items="${empList}">
    <tr ondblclick="goDetail(${emp.empno})"><td>${emp.empno}</td><td>${emp.ename}</td>
        <td>${emp.job}</td><td>${emp.sal}</td>
        <td>${emp.deptno}</td></tr>
    </c:forEach>
empDetail
<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">사원 상세 정보</h2>

</div>
<div class="container">
      <form id="frm01" 
       class="form"  method="post">
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">사원번호</span>
         </div>
         <input name="empno" class="form-control" 
            value="${emp.empno}" readonly/> 
      </div>

      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">사원명</span>
         </div>
         <input name="subject" class="form-control" 
            value="${emp.ename}" placeholder="제목입력하세요"/>   
      </div>
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">직책명</span>
         </div>
         <input name="job" class="form-control" 
            value="${emp.job}" placeholder="직책명입력하세요"/> 
      </div>
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">관리번호</span>
         </div>
         <input name="mgr" class="form-control" 
            value="${emp.mgr}" placeholder="관리번호입력하세요"/> 
      </div>
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">입사일</span>
         </div>
		   <input class="form-control" 
               value='<fmt:formatDate value="${emp.hiredate}" type="both"/>'/>
      </div>
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">급여</span>
         </div>
         <input name="sal" class="form-control" 
            value="${emp.sal}" placeholder="급여입력하세요"/> 
      </div>
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">보너스</span>
         </div>
         <input name="comm" class="form-control" 
            value="${emp.comm}" placeholder="보너스입력하세요"/> 
      </div>
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">부서번호</span>
         </div>
         <input name="deptno" class="form-control" 
            value="${emp.deptno}" placeholder="부서번호입력하세요"/> 
      </div>
      <div class="text-right">
      	<button type="button" onclick="updateProc()" class="btn btn-success">수정</button>
      	<button type="button" onclick="deleteProc()" class="btn btn-danger">삭제</button>
      	<button type="button" onclick="goMain()" class="btn btn-info">메인화면</button>
      </div>
   </form>
</div>
<script>
function updateProc(){
   if(confirm("수정하시겠습니까?")){
	   // 유효성 check
      $("form").attr("action","${path}/updateEmp01.do");
      $("form").submit();
   }
}
function deleteProc(){
   if(confirm("삭제하시겠습니까?")){
      $("form").attr("action","${path}/deleteEmp.do");
   	  $("form").submit();
   }
}
var proc = "${proc}"
if(proc=="upt"){
   if(confirm("수정성공\n조회리스트 화면으로 이동하시겠습니까?")){
      location.href="${path}/getEmp01List.do";
   }
}
if(proc=="del"){
   alert("삭제성공\n조회 리스트화면으로 이동")
   location.href="${path}/getEmp01List.do";
}
function goMain(){
	location.href="${path}/getEmp01List.do"
}
</script>
*/
}
