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
  
</script>
</head>
<body>
<%
	String empnoS = request.getParameter("empno");
  // a03_empDetail.jsp?empno=1000
  Emp emp = new Emp();
  if(empnoS!=null&&!empnoS.trim().equals("")){
    int empno = Integer.parseInt(empnoS);
    A05_PreDAO dao = new A05_PreDAO();
    emp = dao.getEmpDetail(empno);
    System.out.println(emp.getHiredate_s());
    System.out.println(emp.getComm());
    System.out.println(emp.getDeptno());
  }
%>
<h2>사원상세정보(<%=empnoS%>)</h2>
<div class="container">
  <form>
    <div class="row">
      <div class="col-25">
        <label for="empno">사원번호</label>
      </div>
      <div class="col-75">
        <input type="text" id="empno" name="empno" placeholder="사원번호 입력.." value="<%=emp.getEmpno()%>">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="ename">사원명</label>
      </div>
      <div class="col-75">
        <input type="text" id="ename" name="ename" placeholder="사원명 입력.." value="<%=emp.getEname()%>">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="job">직책명</label>
      </div>
      <div class="col-75">
        <input type="text" id="job" name="job" placeholder="직책명 입력.." value="<%=emp.getJob()%>">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="mgr">관리자번호</label>
      </div>
      <div class="col-75">
        <input type="text" id="mgr" name="mgr" placeholder="관리자번호 입력.." value="<%=emp.getMgr()%>">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="hiredateS">입사일</label>
      </div>
      <div class="col-75">
        <input type="text" id="hiredateS" name="hiredateS" placeholder="YYYY-MM-DD" value="<%=emp.getHiredate_s()%>">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="sal">급여</label>
      </div>
      <div class="col-75">
        <input type="text" id="sal" name="sal" placeholder="급여 입력.." value="<%=emp.getSal()%>">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="comm">보너스</label>
      </div>
      <div class="col-75">
        <input type="text" id="comm" name="comm" placeholder="보너스 입력.." value="<%=emp.getComm()%>">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="deptno">부서번호</label>
      </div>
      <div class="col-75">
        <input type="text" id="deptno" name="deptno" placeholder="부서번호 입력.." value="<%=emp.getDeptno()%>">
      </div>
    </div>
    <div class="row">
      <input type="button" value="수정" onclick="uptEmp()" style="background-color:red">
      <input type="button" value="삭제" onclick="delEmp()" style="background-color:green">
      <input type="button" value="조회화면" onclick="gomain()" style="background-color:blue">
    </div>
      <input type = "hidden" name="proc"/>
  </form>
</div>
<script>
  function uptEmp(){
    if(confirm("수정하시겠습니까?")){
      document.querySelector("[name=proc]").value="upt";
      document.querySelector("form").submit();
    }
  }
</script>
<%
  String proc = request.getParameter("proc");
  System.out.println("현재 proc:"+proc);

%>
</table>
</body>
</html>