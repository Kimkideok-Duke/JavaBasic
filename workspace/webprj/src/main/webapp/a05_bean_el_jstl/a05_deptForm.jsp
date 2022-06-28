<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"
    %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=path %>/a00_com/a01_common.css" rel="stylesheet">
<style>

</style>
<script>
	/*
	
	*/
</script>
</head>
<body>
<div class="container">
  <form action="a06_deptBean.jsp">
  <div class="row">
    <div class="col-25">
      <label for="deptno">부서번호</label>
    </div>
    <div class="col-75">
      <input type="text" id="deptno" name="deptno" placeholder="부서번호 입력" value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="dname">부서명</label>
    </div>
    <div class="col-75">
      <input type="text" id="dname" name="dname" placeholder="부서명 입력" value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="loc">부서위치</label>
    </div>
    <div class="col-75">
      <input type="text" id="loc" name="loc" placeholder="부서위치 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="bean호출">
  </div>
  </form>
</div>
<jsp:useBean id="dept" class="webprj.z01_vo.Dept"/>
<jsp:setProperty property="deptno" name="dept"/>
<jsp:setProperty property="dname" name="dept"/>
<jsp:setProperty property="loc" name="dept"/>
<%--
요청갑과 같은 형식의 property가 있으면 자동으로 할당
?deptno=10&dname=인사&loc=서울
property="*"로 선언하면
setDeptno(), setDname(), setLoc() : 요청key의 이름과 할당할 수 있는 type이 일치하면
자동으로 set프러퍼티 메서드를 호출한뒤 처리하여 저장한다.
<jsp:setProperty property="deptno" name="dept"/>
<jsp:setProperty property="dname" name="dept"/>
<jsp:setProperty property="loc" name="dept"/>
--%>
</body>
</html>