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
<%--
# <jsp:forward> 액션 태그
1. 하나의 jsp 페이지에서 다른 jsp 페이지로 요청전달 할 때, 사용된다.
  주의) request.getRequestDispatcher().forward(request, response)와 같이
      request 값을 전달할 수 있다.
2. 기본형식 : <jsp:forward page="이동할 페이지"/>
--%>

<%
	String id = request.getParameter("id");
	String auth = request.getParameter("auth");
  String page01 = "";
  if(auth!=null && !auth.equals("")){
    request.setAttribute("id", id);
    if(auth.equals("admin")){
      page01="a09_admin.jsp";
    }else{
      page01="a10_normal.jsp";
    }
  }
%>
<%if(auth!=null && !auth.equals("")){%>
<jsp:forward page="<%=page01%>"/>
<%}%>

<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="id">아이디</label>
    </div>
    <div class="col-75">
      <input type="text" name="id" placeholder="아이디를 입력하세요"/>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="auth">권한</label>
    </div>
    <div class="col-75">
      <select name="auth">
        <option value="admin">관리자</option>
        <option value="normal">일반사용자</option>
      </select>
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