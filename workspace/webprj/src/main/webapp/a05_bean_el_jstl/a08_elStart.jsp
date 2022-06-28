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
# Expression Language
1. jsp에서 사용가능한 새로운 스크립트 언어
2. el의 주요 기능
    - jsp의 네가지 기본 객체가 제공하는 영역의 속성 사용
    - 집합 객체에 대한 접근 방법 제공
    - 수치 연산, 관계 연상, 논리 연상제 제공
    - 자바 클래스 메서드 호출기능 제공
    - 표현 언어만의 기본 객체 제공
3. 간단한 구분 때문에 표현식 대신 사용
--%>
<body>
<%
	pageContext.setAttribute("num01", 25);
	pageContext.setAttribute("num02", 25);
  request.setAttribute("name", "홍길동");
  // ex)
  request.setAttribute("pname", "연필");
  request.setAttribute("price", 1200);
  request.setAttribute("cnt", 12);
%>
<h2>el 활용</h2>
<table>
        <tr><th>num01</th><td>${num01}</td></tr>
        <tr><th>num02</th><td>${num02}</td></tr>
        <tr><th>num01+num02</th><td>${num01+num02}</td></tr>
        <tr><th>이름</th><td>${name}</td></tr>
</table>

<table>
        <tr><th>pname</th><td>${pname}</td></tr>
        <tr><th>price</th><td>${price}</td></tr>
        <tr><th>cnt</th><td>${cnt}</td></tr>
        <tr><th>합계</th><td>${cnt*price}</td></tr>
</table>

</body>
</html>