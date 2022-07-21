<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
   td{text-align:center;}
</style>
<style>
	.input-group-text{width:100%;background-color:#cfffdf;color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
   $(document).ready(function(){
      <%-- 
      
      --%>   
   });
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">게시판 상세</h2>

</div>
<div class="container">
      <form id="frm01" 
       class="form"  method="post">
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">글번호</span>
         </div>
         <input name="no" class="form-control" 
            value="${board.no}" readonly/>
         <div class="input-group-prepend">
            <span class="text-center input-group-text">상위글번호</span>
         </div>
         <input name="refno" class="form-control" 
               value="${board.refno}" readonly/>   
      </div>


      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">제 목</span>
         </div>
         <input name="subject" class="form-control" 
            value="${board.subject}" placeholder="제목입력하세요"/> 
         <div class="input-group-prepend">
            <span class="text-center input-group-text">첨부파일</span>
         </div>
         <input name="fname" class="form-control" 
            value="${board.fname}"/>
         <script type="text/javascript">
         	$("[name=fname]").click(function(){
         		if(confirm("다운로드 하시겠습니까?")){}
         			location.href="${path}/download.do?fname="+$(this).val()
         	})
         </script>
      </div>
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">작성자</span>
         </div>
         <input name="writer" class="form-control" 
            value="${board.writer}" placeholder="작성자입력하세요"/>
         <div class="input-group-prepend">
            <span class="text-center input-group-text">조회수</span>
         </div>
         <input class="form-control" value="${board.readcnt}"/>   
      </div>
      <%-- 등록일/수정일은 vo로 할당이 형식이 맞지 않기 때문에 
            name="@@@" 삭제처리 --%>
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">등록일</span>
         </div>
		   <input class="form-control" 
               value='<fmt:formatDate value="${board.regdte}" type="both"/>'/>
         <div class="input-group-prepend">
            <span class="text-center input-group-text">수정일</span>
         </div>
		   <input class="form-control" 
               value='<fmt:formatDate value="${board.uptdte}" type="both"/>'/>
      </div>
      <div class="input-group mb-2">
			<div class="input-group-prepend">
				<span class="text-center input-group-text">내 용</span>
			</div>
			<textarea name="content" rows="10" class="form-control"  
				placeholder="내용 입력하세요">${board.content}</textarea>	
		</div> 
      <div class="text-right">
      	<button type="button" onclick="updateProc()" class="btn btn-success">수정</button>
      	<button type="button" onclick="deleteProc()" class="btn btn-danger">삭제</button>
      	<button type="button" onclick="replyProc()" class="btn btn-warning">답글</button>
      	<button type="button" onclick="goMain()" class="btn btn-info">메인화면</button>
      </div>
   </form>
</div>
<script>
function updateProc(){
   if(confirm("수정하시겠습니까?")){
	   // 유효성 check
      $("form").attr("action","${path}/updateBoard.do");
      $("form").submit();
   }
}
function deleteProc(){
   if(confirm("삭제하시겠습니까?")){
      $("form").attr("action","${path}/deleteBoard.do");
   	  $("form").submit();
   }
}
function replyProc(){
   if(confirm("답글을 처리 하시겠습니까?")){
	   $("[name=refno]").val($("[name=no]").val())
	   $("[name=subject]").val("RE:"+$("[name=subject]").val())
	   $("[name=content]").val(
			   "\n\n\n\n\n\n==========상위글==========\n"+
			   $("[name=content]").val());
	   $("form").attr("action","${path}/boardInsertForm.do")
	   $("form").submit();
   }
}
var proc = "${proc}"
if(proc=="upt"){
   if(confirm("수정성공\n조회리스트 화면으로 이동하시겠습니까?")){
      location.href="${path}/boardList.do";
   }
}
if(proc=="del"){
   alert("삭제성공\n조회 리스트화면으로 이동")
   location.href="${path}/boardList.do";
}
function goMain(){
	location.href="${path}/boardList.do"
}
</script>
</body>
</html>