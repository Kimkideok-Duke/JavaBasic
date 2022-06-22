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
<link href="<%=path %>/a00_com\a01_common.css" rel="stylesheet">
<style>

</style>
<script>
  function regEmp(){
    // id로 선언했을 때, 인식가능 id = empno
    if(confirm("사원 정보를 등록하시겠습니까?")){
      var empnoObj = document.querySelector("#empno");
      var enameObj = document.querySelector("#ename");
      var mgrObj = document.querySelector("#mgr");
      var hiredateSObj = document.querySelector("#hiredateS");
      if(empnoObj.value==""){
          alert("사원번호를 입력하세요");
          empnoObj.focus();
          return;
      }
      if(enameObj.value==""){
          alert("사원명을 입력하세요");
          enameObj.focus();
          return;
      }
      if(mgrObj.value.trim()=="" || isNaN(mgrObj.value)){
        alert("관리자번호를 숫자로 입력하세요");
        mgrSObj.focus();
        return;
      }
      if(hiredateSObj.value==""){
          alert("입사일을 입력하세요");
          hiredateSObj.focus();
          return;
      }
      document.querySelector("form").submit();
    }
  }
</script>
</head>
<body>
<h2>사원 등록</h2>
<%
  int empno, mgr, deptno;
  double sal, comm;
  sal = comm = empno = mgr = deptno = 0;

  String empnoS = request.getParameter("empno");
  if(empnoS!=null) empno = Integer.parseInt(empnoS);
  String mgrS = request.getParameter("mgr");
  if(mgrS!=null) mgr = Integer.parseInt(mgrS);
  String deptnoS = request.getParameter("deptno");
  if(deptnoS!=null) deptno = Integer.parseInt(deptnoS);
  String salS = request.getParameter("sal");
  if(salS!=null) sal = Integer.parseInt(salS);
  String commS = request.getParameter("comm");
  if(commS!=null) comm = Integer.parseInt(commS);

  String ename = request.getParameter("ename");
  if(ename==null) ename = "";
  String job = request.getParameter("job");
  if(job==null) job = "";
  String hiredateS = request.getParameter("hiredateS");
  if(hiredateS==null) hiredateS = "";

  log("empno:"+empno);
  log("ename:"+ename);
  log("job:"+job);
  log("mgr:"+mgr);
  log("hiredateS:"+hiredateS);
  log("sal:"+sal);
  log("comm:"+comm);
  log("deptno:"+deptno);
  // 등록 처리를 위한 조건
  String isIns = "N";
  if(empnoS!=null && !empnoS.trim().equals("")){
    // 등록할 Emp() 생성..
    // Emp(int empno, String ename, String job, int mgr, 
    // String hiredate_s, double sal, double comm, int deptno)
    A05_PreDAO dao = new A05_PreDAO();
    dao.insertEmp(new Emp(empno, ename, job, mgr, hiredateS, sal, comm, deptno));
    isIns = "Y";
  }
%>
<script>
  var isIns = "<%=isIns%>";
  if(isIns == "Y"){
    if(confirm("등록성공!!\n조회화면으로 이동하시겠습니까?")){
      location.href="a01_empSchList.jsp"
    }
  }
</script>
<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="empno">사원번호</label>
    </div>
    <div class="col-75">
      <input type="text" id="empno" name="empno" placeholder="사원번호 입력..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ename">사원명</label>
    </div>
    <div class="col-75">
      <input type="text" id="ename" name="ename" placeholder="사원명 입력..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="job">직책명</label>
    </div>
    <div class="col-75">
      <input type="text" id="job" name="job" placeholder="직책명 입력..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="mgr">관리자번호</label>
    </div>
    <div class="col-75">
      <input type="text" id="mgr" name="mgr" placeholder="관리자번호 입력..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="hiredateS">입사일</label>
    </div>
    <div class="col-75">
      <input type="text" id="hiredateS" name="hiredateS" placeholder="YYYY-MM-DD">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="sal">급여</label>
    </div>
    <div class="col-75">
      <input type="text" id="sal" name="sal" placeholder="급여 입력..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="comm">보너스</label>
    </div>
    <div class="col-75">
      <input type="text" id="comm" name="comm" value="" placeholder="보너스 입력..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="deptno">부서번호</label>
    </div>
    <div class="col-75">
      <input type="text" id="deptno" name="deptno" value="" placeholder="부서번호 입력..">
    </div>
  </div>
  <div class="row">
    <input type="button" value="등록" onclick="regEmp()">
  </div>
  </form>
</div>

</body>
</html>