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
<title>사원 상세 정보</title>
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
</body>
</html>