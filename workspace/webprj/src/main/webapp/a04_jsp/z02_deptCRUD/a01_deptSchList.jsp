<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"%>
<%-- 6/20 과제
1. [확인] 부서정보를 a02_DeptSchList.jsp로 처리해서 출력하세요(DB 처리) --%>

<!DOCTYPE html>
<html>
<head>
</head>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
#regBtn{
  width: 50%;
  background-color: blue;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}
#customers tr:nth-child(even){background-color: #f2f2f2;}
#customers tr:hover {background-color: #ddd;}
#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
<script>
    function goInsertPage(){
        location.href="a02_deptInsert.jsp";
    }
</script>
<body>
<%
String dname = request.getParameter("dname"); if(dname==null) dname = "";
String loc = request.getParameter("loc"); if(loc==null) loc = "";
%>
<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="dname">부서명</label>
    </div>
    <div class="col-75">
      <input type="text" id="dname" name="dname" placeholder="부서명 입력" value="<%=dname%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="lname">부서위치</label>
    </div>
    <div class="col-75">
      <input type="text" id="loc" name="loc" placeholder="부서위치 입력" value="<%=loc%>">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  <div class="row">
    <input type="button" id="regBtn" value="등록" onclick="goInsertPage()">
  </div>
  </form>
</div>

<%-- <h2>사원 정보</h2>
<form method="post">
    부서명:<input type="text" name="dname" value="<%=dname%>"/><br>
    부서위치:<input type="text" name="loc" value="<%=loc%>"/><br>
    <input type="button" id=regBtn value="등록" onclick="goInsertPage()"/>
    <input type="submit" value="검색"/>
</form> --%>

<%
A05_PreDAO dao = new A05_PreDAO();
%>

<table id="customers">
        <tr><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>
        <% for(Dept d:dao.getDeptList2(dname, loc)){%>
        <tr><td><%=d.getDeptno()%></td><td><%=d.getDname()%></td><td><%=d.getLoc()%></td></tr>
        <%}%>
</table>
</body>
</html>