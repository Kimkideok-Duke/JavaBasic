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
  String proc = request.getParameter("proc");
  if(proc==null) proc="";
  if(proc!=null){
    System.out.println("현재 proc:"+proc);
  }
	String deptnoS = request.getParameter("deptno");

  Dept dept = new Dept();
  if(deptnoS!=null&&!deptnoS.trim().equals("")){
    int deptno = Integer.parseInt(deptnoS);
    A05_PreDAO dao = new A05_PreDAO();
    if(proc.equals("upt")){
      String dname = request.getParameter("dname");
      if(dname==null) dname = "";
      String loc = request.getParameter("loc");
      if(loc==null) loc = "";
      dept = new Dept(deptno, dname, loc);
      dao.updateDept(dept);
    }
    dept = dao.getDeptDetail(deptno);
  }
%>
<script>
  var proc = "<%=proc%>";
  if(proc!=""){
    if(proc=="upt"){
      if(confirm("수정처리가 되었습니다\n메인화면으로 이동하시겠습니까?")){
        location.href="a01_deptSchList.jsp";
      }
    }
  }
</script>


<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="deptno">부서번호</label>
    </div>
    <div class="col-75">
      <input type="text" id="deptno" name="deptno" placeholder="부서번호 입력" value="<%=dept.getDeptno()%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="dname">부서명</label>
    </div>
    <div class="col-75">
      <input type="text" id="dname" name="dname" placeholder="부서명 입력" value="<%=dept.getDname()%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="loc">부서위치</label>
    </div>
    <div class="col-75">
      <input type="text" id="loc" name="loc" placeholder="부서위치 입력" value="<%=dept.getLoc()%>">
    </div>
  </div>
  <div class="row">
    <input type="button" value="수정" onclick="uptDept()" style="background-color:green">
    <input type="button" value="삭제" onclick="delDept()" style="background-color:red">
    <input type="button" value="조회화면" onclick="gomain()" style="background-color:blue">
  </div>
    <input type="hidden" name="proc"/>
  </form>
</div>
<script>
  function uptDept(){
    if(confirm("수정하시겠습니까?")){
      document.querySelector("[name=proc]").value="upt";
      document.querySelector("form").submit();
    }
  }
  function delDept(){
    if(confirm("삭제하시겠습니까?")){
      document.querySelector("[name=proc]").value="del";
      document.querySelector("form").submit();
    }
  }
  function gomain(){
    location.href="a01_empSchList.jsp"
  }
</script>
<%
  

%>
</body>
</html>