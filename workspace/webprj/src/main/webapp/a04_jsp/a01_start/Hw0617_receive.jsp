<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        String answer = request.getParameter("answer");
    %>
    <%if(answer.equals("2")){%>
        <h2>정답입니다</h2>
    <%}else{%>
        <h2>오답입니다</h2>
    <%}%>
</body>
</html>