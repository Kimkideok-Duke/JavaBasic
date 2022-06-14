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
    String product = request.getParameter("product");
    String price = request.getParameter("price");
%>
    <h2>물건 : <%=product%>, 가격 : <%=price%></h2>
</body>
</html>