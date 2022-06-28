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
<%-- 2022-06-27
[1단계:개념] 1. useBean 태그 의 기본 속성과 하위 속성을 예제를 통해서 기술하세요.
            <jsp:useBean id="빈이름" class="자바패키지.클래스명" scope="범위" />
                  id : jsp 페이지에서 자바빈 객체에 접근할 때, 사용할 이름
                  class : 패키지 이름을 포함한 자바빈 클래스의 완전한 이름
                  scope : 자바빈 객체가 저장될 영역을 지정 page, request, session, application중 하나를 값으로 갖는다.
                  

[1단계:확인] 2. useBean을 이용하여 물건명/가격/갯수를 저장하여 출력하게 처리히세요(vo==>bean)

[1단계:확인] 3. useBean을 이용하여 좋아하는 선수의 팀/선수명/성적을 form으로 입력해서 해당 화면에서 출력처리하세요.


[1단계:확인] 4. 부서정보를 등록하는 form을 만들고 useBean을 이용해서 등록 처리하고, 현재 등록된 내용을 리스트 처리하세요(DAO)


[1단계:확인] 5. el을 이용하여 곰돌이 3마리가 먹은 빵의 갯수가 20개일 때, 균등 배분 빵의 갯수와 나머지 갯수 출력하세요.
 --%>
<body>
<%-- [1단계:확인] 2. useBean을 이용하여 물건명/가격/갯수를 저장하여 출력하게 처리히세요(vo==>bean) --%>
<jsp:useBean id="prod" class="webprj.z01_vo.Product001" scope="request"/>
<%
	prod.setPname("연필");
	prod.setPrice(1200);
	prod.setRcnt(300);
%>
<h2>useBean을 이용하여 물건명/가격/갯수를 저장하여 출력하게 처리히세요(vo==>bean)</h2>
<table>
        <tr><th>물건명</th><td><%=prod.getPname()%></td></tr>
        <tr><th>가격</th><td><%=prod.getPrice()%></td></tr>
        <tr><th>갯수</th><td><%=prod.getRcnt()%></td></tr>
</table>

<%-- [1단계:확인] 3. useBean을 이용하여 좋아하는 선수의 팀/선수명/성적을 form으로 입력해서 해당 화면에서 출력처리하세요. --%>
<jsp:useBean id="player" class="webprj.z01_vo.Player" scope="request"/>
<%
	player.setTeam("아스날");
	player.setName("외데고르");
	player.setScore("2골 8도움");
%>
<h2>useBean을 이용하여 좋아하는 선수의 팀/선수명/성적을 form으로 입력해서 해당 화면에서 출력처리하세요.</h2>
<table>
        <tr><th>팀</th><td><%=player.getTeam()%></td></tr>
        <tr><th>선수명</th><td><%=player.getName()%></td></tr>
        <tr><th>성적</th><td><%=player.getScore()%></td></tr>
</table>

<%-- [1단계:확인] 4. 부서정보를 등록하는 form을 만들고 useBean을 이용해서 등록 처리하고, 현재 등록된 내용을 리스트 처리하세요(DAO) --%>
<h2>부서정보를 등록하는 form을 만들고 useBean을 이용해서 등록 처리하고, 현재 등록된 내용을 리스트 처리하세요(DAO)</h2>
<jsp:useBean id="dept" class="webprj.z01_vo.Dept" scope="request"/>
<jsp:setProperty property="deptno" name="dept"/>
<jsp:setProperty property="dname" name="dept"/>
<jsp:setProperty property="loc" name="dept"/>

<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="deptno">부서번호</label>
    </div>
    <div class="col-75">
      <input type="text" id="deptno" name="deptno" placeholder="부서번호 입력" 
        value="<%=dept.getDeptno()!=0?dept.getDeptno():0%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="dname">부서명</label>
    </div>
    <div class="col-75">
      <input type="text" id="dname" name="dname" placeholder="부서명 입력" 
        value="<%=dept.getDname()!=null?dept.getDname():""%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="loc">부서위치</label>
    </div>
    <div class="col-75">
      <input type="text" id="loc" name="loc" placeholder="부서위치 입력" 
        value="<%=dept.getLoc()!=null?dept.getLoc():""%>">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="등록">
  </div>
  </form>
</div>
<%
A05_PreDAO dao = new A05_PreDAO();
if(dept.getDname()!=null){
  dao.insertDept(dept);
}
%>
<table>
<tr><th>부서번호</th><th>부서명</th><th>위치</th></tr>
<%
  for(Dept d:dao.getDeptList("","")){%>
        <tr>
            <td><%=d.getDeptno()%></td>
            <td><%=d.getDname()%></td>
            <td><%=d.getLoc()%></td>
        </tr>
  <%}%>
</table>


<%-- [1단계:확인] 5. el을 이용하여 곰돌이 3마리가 먹은 빵의 갯수가 20개일 때, 균등 배분 빵의 갯수와 나머지 갯수 출력하세요. --%>
<h2>el을 이용하여 곰돌이 3마리가 먹은 빵의 갯수가 20개일 때, 균등 배분 빵의 갯수와 나머지 갯수 출력하세요.</h2>
<%
	request.setAttribute("bear", 3);
	request.setAttribute("bread", 20);
%>
<h3>빵 : ${bread} / 곰 : ${bear} = 균등 배분 빵의 갯수 : ${bread/bear}</</h3>
<h3>빵 : ${bread} % 곰 : ${bear} = 나머지 갯수 : ${bread+bear}</</h3>
</body>
</html>