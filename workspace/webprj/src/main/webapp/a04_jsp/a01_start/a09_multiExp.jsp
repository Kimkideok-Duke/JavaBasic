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
    String []favorFood = request.getParameterValues("favorFood");
    if(favorFood!=null && favorFood.length>0){
        for(String favor:favorFood){%>
            <h3><%=favor %></h3>
        <%}
    }
%>
</body>
</html>