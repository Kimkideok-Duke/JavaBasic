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
# 서버단위로 설정하는 에러는 상단에 isErrorPage="true"를 설정하지 않아도 된다.
 --%>
<body>
<h2>NULLPointerException(객체가 생성되지 않았습니다.)</h2>
</body>
</html>