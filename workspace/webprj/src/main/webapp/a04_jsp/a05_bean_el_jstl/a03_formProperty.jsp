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
<%-- 
# form의 데이터 처리하는 Bean 객체
1. useBean을 활용하면 form의 데이터를 효과적으로 property명으로 mapping 시켜 처리가 가능하다.
2. form요청갑과 Bean 객체 연관관계
  <input name="ename"
    ==> 전송하여 ?name=홍길동
    class Emp{
      public setName(String name)
    }
    <jsp:setProperty name="아이디명" property="ename"
--%>
<body>
<h2>useBean을 활용하여 요청값 받기</h2>
<jsp:useBean id="emp" class="webprj.z01_vo.Emp" scope="session"/>
<jsp:setProperty property="ename" name="emp"/>

<div class="container">
  <form action="a04_showBean.jsp">
  <div class="row">
    <div class="col-25">
      <label for="ename">사원명</label>
    </div>
    <div class="col-75">
      <input type="text" id="ename" name="ename" placeholder="사원명 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="요청값 전달">
  </div>
  </form>
</div>

</body>
</html>