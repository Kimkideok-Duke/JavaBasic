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
<%
	String req = request.getParameter("");
%>
<table>
        <tr><th>페이지 범위 데이터</th><td><%=pageContext.getAttribute("page01")%></td></tr>
        <tr><th>requset 범위 데이터</th><td><%=request.getAttribute("request02")%></td></tr>
        <tr><th>session 범위 데이터</th><td><%=session.getAttribute("session03")%></td></tr>
        <tr><th>application 범위 데이터</th><td><%=application.getAttribute("application04")%></td></tr>
</table>

</body>
</html>