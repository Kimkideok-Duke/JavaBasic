<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"
    %>
<%
request.setCharacterEncoding("utf-8");
// String path 부분 삭제
// a04_includeDirective와 변수 중복
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
	int age = 25;
  String loc = "서울 신림동";
%>
<h2>이름<%=name%></h2>


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