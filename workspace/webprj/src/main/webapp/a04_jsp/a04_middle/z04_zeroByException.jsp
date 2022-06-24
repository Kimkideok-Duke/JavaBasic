<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
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
<h2>zerobyexception</h2>
<table>
        <tr><th>예외 내용</th><td><%=exception.getMessage()%></td></tr>
        <tr><th>예외 클래스</th><td><%=exception.getClass()%></td></tr>
</table>
</body>
</html>