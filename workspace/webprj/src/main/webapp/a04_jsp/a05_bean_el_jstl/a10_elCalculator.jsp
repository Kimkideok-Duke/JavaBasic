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
# el의 연산자
1. 수치 연산자 : +, -, *, %
2. 비교 연산자 : ==/eq, !=ne, < lt, <= le, > gt, >= ge
3. 논리 연산자 : && and, || or, ! no,
4. empty : null, 공백, 배열의 길이가 0
5. 삼항 연산자 : 조건?값1:값2
--%>
<body>
<%
	request.setAttribute("num01", 25);
	request.setAttribute("num02", 5);
	request.setAttribute("price", 500000);
	request.setAttribute("cnt", 25);
%>
<h2>${num01} + ${num02} = ${num01+num02}</h2>
<h2>${num01} - ${num02} = ${num01-num02}</h2>
<h2>${num01} * ${num02} = ${num01*num02}</h2>
<h2>${num01} / ${num02} = ${num01/num02}</h2>
<h2>${num01} % ${num02} = ${num01%num02}</h2>
<h2>${num01} == ${num02} = ${num01 == num02}</h2>
<h2>${num01} != ${num02} = ${num01 ne num02}</h2>
<h2>논리식 : ${num01>=10 && num02<=20}</h2>
<h2>empty : ${empty name}</h2>
<h2>not empty : ${not empty num01}</h2>
<h2>삼항연산식 : ${not empty num01?'num01 값있음':'num01 값없음'}</h2>
<%-- ex) --%>
<h2>등급 : ${cnt*price>=1000000?'VIP':'일반고객'}</h2>
</body>
</html>