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
      $("h1").click(function(){
        // 선택자에 의해 여러개의 DOM을 한번에 속성과 문자열 변경
        $("h2").css("color","navy").text("문자열변경");
        // 개별적인 데이터는 .eq(index)로 특정한 내용에 대하여 지정하여 처리할 수 있다.
        $("h2").eq(2).attr("align","left").text("선택된 h2");
        $("h2").eq(0).attr("align","left").text("첫번째 h2").css("color","blue");
        $("h2").eq(-1).attr("align","left").text("마지막 h2").css("color","red");
        // :even, :odd  짝수 번째/ 홀수 번째를 선택해서 처리가능
        $("h2:even").css("background-color","yellow")
      });
      // ex) 3X3 빙고 테이블, 빙고 클릭, 해당 테이블 특정 cell 배경 빨강
      // var rIdx = parseInt(Math.random())
      $("td").each(function(idx){
        $(this).text(idx+1);
      });
      // $("h1"), $("#아이디명") : id="btn01"
      // $(".클래스명") class="cls01"
      // $("[속성=속성값]")
      $("#btn01").click(function(){
        $("td").css({"height":"33%", "background":""}).each(
          function(idx){$(this).text(idx+1);});
        var rIdx = Math.floor(Math.random()*$("#tab01 td").length)
        $("td").eq(rIdx).css("background","red").text("빙고")
      })
   });
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h1>클릭하세요</h1>
  <h2>타이틀</h2>
  <h2>타이틀</h2>
  <h2>타이틀</h2>
  <h2>타이틀</h2>
  <h2>타이틀</h2>
  <h2>타이틀</h2>
  <table id="tab01" border width="200" height="200" align="center">
    <col width="33%"><col width="33%"><col width="33%">
    <tr><td></td><td></td><td></td><tr>
    <tr><td></td><td></td><td></td><tr>
    <tr><td></td><td></td><td></td><tr>
  </table>
  <input type="button" id="btn01" value="빙고"/><br>

</div>
<div class="container">
   <form id="frm01" class="form-inline"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="form-control mr-sm-2" placeholder="제목" />
       <input class="form-control mr-sm-2" placeholder="내용" />
       <button class="btn btn-info" type="submit">Search</button>
    </nav>
   </form>
   <table class="table table-hover table-striped">
      <col width="10%">
      <col width="50%">
      <col width="15%">
      <col width="15%">
      <col width="10%">
    <thead>
    
      <tr class="table-success text-center">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회</th>
      </tr>
    </thead>   
    <tbody>
       <tr><td></td><td></td><td></td><td></td><td></td></tr>
       <tr><td></td><td></td><td></td><td></td><td></td></tr>
       <tr><td></td><td></td><td></td><td></td><td></td></tr>
    </tbody>
   </table>    
    
</div>
</body>
</html>