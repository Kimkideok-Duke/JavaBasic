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
# el로 객체 설정과 활용
1. el 태그는 객체가 설정이 되면 property 개념으로 가져올 수 있다.
  getAge() ==> 프로퍼티 age
2. 객체 선언과 프로퍼티로 가져오기
  ${객체명.프로퍼티명} ex) ${emp.ename} ==> emp.getEname()

--%>
<body>
<%
	request.setAttribute("d01", new Dept(50, "인사", "서울 방배동"));
	request.setAttribute("m01", new Member011("himan", "7777", "홍길동", 30000, "관리자"));
%>

<h2>el로 객체를 가져오기</h2>
<table><col width="30%">
        <tr><th>부서번호</th><td>${d01.deptno}</td></tr>
        <tr><th>부서명</th><td>${d01.dname}</td></tr>
        <tr><th>부서위치</th><td>${d01.loc}</td></tr>
</table>
<table><col width="30%">
        <tr><th>아이디</th><td>${m01.id}</td></tr>
        <tr><th>비밀번호</th><td>${m01.pass}</td></tr>
        <tr><th>이름</th><td>${m01.name}</td></tr>
        <tr><th>포인트</th><td>${m01.point}</td></tr>
        <tr><th>권한</th><td>${m01.auth}</td></tr>
</table>
</body>
</html>