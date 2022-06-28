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
<body>
<%
	String req = request.getParameter("");
%>


<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="dname">부서명</label>
    </div>
    <div class="col-75">
      <input type="text" id="dname" name="dname" placeholder="부서명 입력" value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ename">사원1</label>
    </div>
    <div class="col-75">
      <input type="text" id="ename" name="ename" placeholder="사원명 입력" value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ename">사원2</label>
    </div>
    <div class="col-75">
      <input type="text" id="ename" name="ename" placeholder="사원명 입력" value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ename">사원3</label>
    </div>
    <div class="col-75">
      <input type="text" id="ename" name="ename" placeholder="사원명 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div>
<table><col width="30%">
        <tr><th>부서명</th><td>${param.dname}</td></tr>
        <tr><th>사원1</th><td>${paramValues.ename[0]}</td></tr>
        <tr><th>사원2</th><td>${paramValues.ename[1]}</td></tr>
        <tr><th>사원3</th><td>${paramValues.ename[2]}</td></tr>
</table>
</body>
</html>