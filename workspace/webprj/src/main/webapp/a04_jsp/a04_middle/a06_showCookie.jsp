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
%>
<h2>쿠키확인하기</h2>
<table>
        <tr><th>쿠키이름</th><th>쿠키값</th></tr>
        <%
        for(Cookie ck:request.getCookies()){
        %>
        <tr><td><%=ck.getName()%></td><td><%=ck.getValue()%></td></tr>
        <%}%>
</table>
</body>
</html>