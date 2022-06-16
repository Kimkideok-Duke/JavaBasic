<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>서버에서 받은 정보</h2>
    <h3>아이디:${param.id}</h3>
    <h3>패스워드:${param.passwd}</h3>
    <%
    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");
    if(id.equals("himan")){
        if(passwd.equals("7777")){%>
            <h2>로그인 성공</h2>
        <%}
    }
    %>
</body>
</html>