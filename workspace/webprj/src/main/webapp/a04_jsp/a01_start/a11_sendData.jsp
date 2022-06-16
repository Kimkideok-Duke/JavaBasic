<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
# form 요소객체에 따른 데이터 전송
1. 기본 처리 형식
    <form action="" method="post|get">
        <input type="text" name="send01">
        <input type="submit">
    </form>
2. 기본적으로 action 속성에 지정한 페이지에 form에 포함된 요소 객체들이
    name="키" value="값"으로 query string을 만들어 서버에 전송된다.
    action의 페이지?키=값
3. action은 현재페이지, method는 get방식을 default 설정된다.
--%>
    <form>
        이름:<input type="text" name="name">
        <input type="submit">
    </form>
    <%=request.getParameter("name")%>
    <%=request.getParameter("age")%>
    <form action="a12_receive.jsp" method="post">
        이름 : <input type="text" name="name"><br>
        나이 : <input type="text" name="age"><br>
        <input type="submit">
    </form>
    <%-- ex) --%>
    <form method="post" action="a12_receive.jsp">
        물건명 : <input type="text" name="pname"><br>
        가격 : <input type="text" name="price"><br>
        갯수 : <input type="text" name="cnt"><br>
        <input type="submit" value="구매">
    </form>
</body>
</html>