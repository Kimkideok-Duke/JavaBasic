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
  String proc = request.getParameter("proc");
  if(proc==null) proc="";
  int empno = 0; 
  String empnoS = request.getParameter("empno");

  // a03_empDetail.jsp?empno=1000
  Emp emp = new Emp();
  if(empnoS!=null&&!empnoS.trim().equals("")){
    empno = Integer.parseInt(empnoS);
    A05_PreDAO dao = new A05_PreDAO();
    System.out.println(proc);
    // 수정처리
    if(proc.equals("upt")){
      int mgr, deptno;
      double sal, comm;
      sal = comm = mgr = deptno = 0;
      String mgrS = request.getParameter("mgr");
      if(mgrS!=null) mgr = Integer.parseInt(mgrS);
      String deptnoS = request.getParameter("deptno");
      if(deptnoS!=null) deptno = Integer.parseInt(deptnoS);
      String salS = request.getParameter("sal");
      if(salS!=null) sal = Double.parseDouble(salS);
      String commS = request.getParameter("comm");
      if(commS!=null) comm = Double.parseDouble(commS);

      String ename = request.getParameter("ename");
      if(ename==null) ename = "";
      String job = request.getParameter("job");
      if(job==null) job = "";
      String hiredateS = request.getParameter("hiredateS");
      if(hiredateS==null) hiredateS = "";
      // 수정 처리를 위한 객체 매개변수 전달
      emp = new Emp(empno, ename, job, mgr, hiredateS, sal, comm, deptno);
      dao.updateEmp(emp);
    }
    if(proc.equals("del")){
      dao.deleteEmp(empno);
    }
    emp = dao.getEmpDetail(empno);
  }


%>
<script>
  var proc = "<%=proc%>";
  if(proc!=""){
    if(proc=="upt"){
      if(confirm("수정처리가 되었습니다\n메인화면으로 이동하시겠습니까?")){
        location.href="a01_empSchList.jsp";
      }
    }
    if(proc=="del"){
      if(confirm("삭제 되었습니다\n메인화면으로 이동")){
        location.href="a01_empSchList.jsp";
      }
    }
  }
</script>
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
  function delEmp(){
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
</table>
</body>
</html>