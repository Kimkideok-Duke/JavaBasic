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
	String isPass = request.getParameter("isPass");
  String page01 = "";
  if(isPass!=null && !isPass.equals("")){
    if(isPass.equals("pass")){
      page01="a12_pass.jsp";
    }else{
      page01="a13_fail.jsp";
    }
  }
%>
<%if(isPass!=null && !isPass.equals("")){%>
<jsp:forward page="<%=page01%>"/>
<%}%>



<div class="container">
  <form>
   <div class="row">
    <div class="col-25">
      <label for="isPass">합격여부</label>
    </div>
    <div class="col-75">
      <select name="isPass">
        <option value="pass">합격</option>
        <option value="fail">불합격</option>
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