<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- 이름 : <%=request.getParameter("name")%><br>
    나이 : <%=request.getParameter("age")%> --%>
    <%
    String pname = request.getParameter("pname");
    if(pname==null) pname="";
    String priceS = request.getParameter("price");
    int price = 0; if(priceS!=null) price=Integer.parseInt(priceS);
    String cntS = request.getParameter("cnt");
    int cnt = 0; if(cntS!=null) cnt=Integer.parseInt(cntS);
    int sum = price*cnt;
    %>
    물건명 : <%=pname%><br>
    가격 : <%=price%><br>
    갯수 : <%=cnt%><br>
    총비용은 : <%=sum%>
</body>
</html>