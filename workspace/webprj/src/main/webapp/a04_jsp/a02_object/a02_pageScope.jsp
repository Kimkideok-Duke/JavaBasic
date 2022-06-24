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
# 기본 객체와 영역
1. jsp의 4가지 영역
  1) page(pageContext) : 하나의 페이지를 처리할 때 사용되는 영역
  2) request : 하나의 HTTP요청을 처리할 때, 사용되는 영역
  3) session : 하나의 웹 브라우저와 관련된 영역
  4) application : 하나의 웹 어플리케이션과 관련된 영역
2. 기능 메서드
  1) XXX.setAttribute("저장키", "저장값/객체"); : 키로 저장
  2) XXX.getAttribute("저장키"); 키로 호출
  3) XXX.removeAttribute("저장키") : 저장된 키의 속성을 삭제

--%>
<%
  // 1. page 범위 설정
  pageContext.setAttribute("page01", "페이지범위 데이터(page scope)");
  // 2. request 범위 설정
  request.setAttribute("request02", "request범위 데이터(request scope)");
  // 3. session 범위 설정
  session.setAttribute("session03", "session범위 데이터(session scope)");
  // 4. application 범위 설정
  application.setAttribute("application04", "application범위 데이터(application scope)");
  String req = request.getParameter("req");
  if(req!=null&&req.equals("Y")){
    // request 범위한에서 request, respons를 가지고, 해당 페이지로 이동
    request.getRequestDispatcher("a03_requestScope.jsp").forward(request,response);
    // response.sendDirect("") : 서버단에서 바로 페이지 이동
    //      request와 response를 가지고 가지 않음
    // location.href="a04_sessionScope.jsp"; 클라이언트 단에서 페이지 이동
  }
%>
<table>
        <tr><th>페이지 범위 데이터</th><td><%=pageContext.getAttribute("page01")%></td></tr>
        <tr><th>requset 범위 데이터</th><td><%=request.getAttribute("request02")%></td></tr>
        <tr><th>session 범위 데이터</th><td><%=session.getAttribute("session03")%></td></tr>
        <tr><th>application 범위 데이터</th><td><%=application.getAttribute("application04")%></td></tr>
</table>
<div class="container">
  <form><input type="hidden" name="req" value="Y"/></form>
  <div class="row">
    <input type="button" value="session범위확인" onclick="goSession()">
    <input type="button" value="request범위확인" onclick="goRequest()">
  </div>
</div>
<script type="text/javascript">
  function goSession(){
    location.href = "a04_sessionScope.jsp";
  }
  function goRequest(){
    document.querySelector("form").submit();
  }
</script>
</body>
</html>