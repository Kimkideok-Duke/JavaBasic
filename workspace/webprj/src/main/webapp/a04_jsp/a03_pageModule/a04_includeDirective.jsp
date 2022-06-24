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
# include 디렉티브
1. 코드 차원에서 포함
2. 구분 : <%@ include file="포함할파일" %>
3. 활용
  - 모든 jsp 페이지에서 사용되는 변수 지정
  - 저작권 표시와 같은 간단하면서도 모든 페이지에서 중복되는 문장
 --%>
<body>
<%
	String name = "홍길동";
%>
<h2>현재 페이지</h2>
<%@ include file="a05_subPage.jsp"%>
<h3>나이:<%=age%></h3>
<h3>사는 곳:<%=loc%></h3>

<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="dname">@@@</label>
    </div>
    <div class="col-75">
      <input type="text" id="dname" name="dname" placeholder="부서명 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div>
<table>
        <tr><th>###</th><th>###</th><th>###</th></tr>
        <tr><td></td><td></td><td></td></td></tr>
</table>
</body>
</html>