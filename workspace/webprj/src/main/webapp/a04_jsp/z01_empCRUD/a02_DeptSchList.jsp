<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.A05_PreDAO"
    import="webprj.z01_vo.Dept"%>
<%-- 6/20 과제
1. [확인] 부서정보를 a02_DeptSchList.jsp로 처리해서 출력하세요(DB 처리) --%>
<%
A05_PreDAO dao = new A05_PreDAO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
    <h2>부서 정보</h2>
    <form method="post">
        부서번호:<input type="text" name="deptno" value=""/><br>
        부서명:<input type="text" name="dname" value=""/><br>
        <input type="submit" value="검색"/>
    </form>
    <table id="customers">
        <tr><th>부서번호</th><th>부서명</th><th>위치</th></tr>
        <% for(Dept d:dao.getDeptList(new Dept("",""))){%>
        <tr><th>d.getDeptno()</th><th>d.getDname()</th><th>d.getLoc()</th></tr>
        <%}%>
    </table>
</body>
</body>
</html>