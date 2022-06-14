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
    // a05_receiveParam.jsp?name=홍길동&age=25
    // 요청값을 받는 소스?요청key=요청값
    // 요청을 받는 페이지
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    // 요청key가 없을 때는 null
    // 요청값이 있을 때는 key에 대한 값을 출력한다.
    // 요청값은 일단, 문자열로 받는다.
    // ex) a06_rev.jsp 요청키 product, 요청값을 사과
    // ex) a06_rev.jsp 요청키 price, 요청값을 3000
    //      요청키와 요청값에 의해서 데이터를 a06_rev.jsp 에 전송하고 화면에는 
    //      물건명 @@@, 가격 @@@ 출력되게 하세요. 
%>
    <h2>첫요청값:<%=name%></h2>
    <h2>두번요청값:<%=age%></h2>
</body>
</html>