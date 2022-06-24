<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"
    %>
<% // isErrorPage : 에러가 발생할 때, 나타날 페이지
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근면하고 성실하게 살아라. 그리고 늘 유익한 일에 열중하라(프랭클린)</title>
<link href="<%=path %>/a00_com/a01_common.css" rel="stylesheet">
<style>

</style>
<script>
	window.onload=function(){
    // document.querySelector("h3").innerText="";
  }
</script>
</head>
<%

%>
<body>
  <h2 align="center">에러 처리 페이지</h2>
  <h3 align="center">에러의 내용:<%=exception.getMessage()%></h3>


</body>
</html>