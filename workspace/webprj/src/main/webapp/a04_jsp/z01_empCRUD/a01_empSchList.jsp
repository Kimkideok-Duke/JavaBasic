<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.A05_PreDAO"
    import="webprj.z01_vo.Emp"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
  width: 50%;
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
      location.href="a02_empInsert.jsp";
  }
</script>
<%
String ename = request.getParameter("ename");
String job = request.getParameter("job");
if(ename==null) ename = "";
if(job==null) job = "";
%>
<%-- 
# 사원 정보 리스트/등록/수정/삭제 처리하기
1. 기본 화면 구성
    1) 테이블
    2) form 구성
    3) css 적용
2. DAO 호출
3. 기본 출력
4. 요청값에 의한 검색 처리
--%>
<body>
  <h2>사원 정보</h2>
  <form method="post">
      사원명:<input type="text" name="ename" value="<%=ename%>"/><br>
      직책명:<input type="text" name="job" value="<%=job%>"/><br>
      <input type="button" id=regBtn value="등록" onclick="goInsertPage()"/>
      <input type="submit" value="검색"/>
  </form>
<%
A05_PreDAO dao = new A05_PreDAO();
/*
# 요청값에 의한 검색 처리
1. form에 있는 요청값을 받기
2. 조건문에 의해 null에 대한 처리
3. DAO에 VO 객체 넘겨주기
*/

/*
for(Emp e:dao.getEmpList2(new Emp("",""))){
    e.getEmpno();
    e.getEname();
    e.getJob();
    e.getMgr();
    e.getSal();
    e.getDeptno();
}
*/
%>
    <table id="customers">
        <tr><th>사원번호</th><th>사원명</th><th>직책</th><th>급여</th><th>부서번호</th></tr>
        <% for(Emp e:dao.getEmpList2("","")){%>
        <tr><td><%=e.getEmpno()%></td><td><%=e.getEname()%></td><td><%=e.getJob()%></td><td><%=e.getSal()%></td><td><%=e.getDeptno()%></td></tr>
        <%}%>
    </table>
</body>
</html>