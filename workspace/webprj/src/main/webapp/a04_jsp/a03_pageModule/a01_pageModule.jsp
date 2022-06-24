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
# 페이지 모듈화
1. <jsp:include> 액션태그
  1) 다른 jsp페이지의 실행 결과를 현재 위치에 삽입
2. 구문
  1) <jsp:include page="포함할페이지" flush="true"/>
  2) page 속성 : 포함할 jsp페이지
  3) flush 속성 : 지정한 jsp 페이지를 싫행하시 전에 출력버퍼를 
      플러시할지의 여부를 지정한다. true이면 출력 버퍼를 플러시하고 
      false이면 하지 않는다.
3. <jsp:param> 액션 태그
    1) 신규 파라미터를 추가하는데 사용
      <jsp:param name="파라미터이름" value="값"/>

--%>
<body>
<%
%>
<jsp:include page="a02_subPage.jsp">
  <jsp:param name="name" value="사과"/>
  <jsp:param name="price" value="3000"/>
  <jsp:param name="cnt" value="2"/>
</jsp:include>

<jsp:include page="a03_mainPage.jsp">
  <jsp:param value="홍길동" name="name"/>
  <jsp:param value="25" name="age"/>
  <jsp:param value="서울 방배동" name="loc"/>
</jsp:include>

<h2>현재 페이지!!</h2>
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