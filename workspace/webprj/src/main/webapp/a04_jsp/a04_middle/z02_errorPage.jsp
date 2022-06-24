<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"
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
<%
	String req = request.getParameter("");
%>
<h2>에러가 발생했습니다</h2>
<table>
        <tr><th>에러내용</th><td><%=exception.getMessage()%></td></tr>
        <tr><th>에러클래스</th><td><%=exception.getClass()%></td></tr>
</table>
</body>
</html>