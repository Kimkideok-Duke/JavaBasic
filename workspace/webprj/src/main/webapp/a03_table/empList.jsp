<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    import="webprj.dao.A05_PreDAO"
    import="webprj.z01_vo.Emp"
    import="java.util.*"
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
    border-collapse: collapse;
    width: 100$;
}

th,td {
	padding: 8px;
    text-align: center;
    border-bottom: 1px solid #DDD;
}
th{background-Color:MediumSeaGreen;}
tr:nth-child(even){background-Color: #f2f2f2;}
tr:hover {background-Color: #D6EEEE;}
</style>
<body>
<%
    A05_PreDAO dao = new A05_PreDAO();
	// 입력한내용 서버에 받는 부분
	String ename = request.getParameter("ename");
	if(ename==null) ename="";
	String job = request.getParameter("job");
	if(job==null) job="";
%>
<h2 align="center">사원정보</h2>

<form>
	<label for="fname">사원명:</label><br>
	<input type="text" id="fname" name="ename" value="<%=ename %>"><br>
	<label for="Lname">직책명:</label><br>
	<input type="text" id="lname" name="job" value="<%=job %>"><br><br><br>
	<input type="submit" value="검색">
</form>

<table align="center">
    <tr>
        <th>사원번호</th>
        <th>사원명</th>
        <th>직책</th>
        <th>관리자번호</th>
        <th>급여</th>
        <th>보너스</th>
        <th>부서번호</th>
    </tr>
    <%
    Map<String, String> sch = new HashMap<String,String>();
    sch.put("ename",ename);
    sch.put("job",job);
    for(Emp e:dao.getEmpList(sch)){
    %>
    <tr>
        <td><%=e.getEmpno()%></td>
        <td><%=e.getEname()%></td>
        <td><%=e.getJob()%></td>
        <td><%=e.getMgr()%></td>
        <td><%=e.getSal()%></td>
        <td><%=e.getComm()%></td>
        <td><%=e.getDeptno()%></td>
    </tr>
    <%
    }
    %>

</table>
</body>
</html>