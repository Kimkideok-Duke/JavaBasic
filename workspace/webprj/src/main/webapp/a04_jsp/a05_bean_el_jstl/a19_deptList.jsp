<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"
    import="java.util.*"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<fmt:requestEncoding value="UTF-8"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/a00_com/a01_common.css" rel="stylesheet">
<style>
    
</style>
<script src="${path}/a00_com/jquery-3.6.0.js" type="text/javascript"></script>
<script>
    /*
    
    */
    $(document).ready(function(){
       $("h1").text("시작!");
    });
</script>
</head>
<body>
<%-- 

--%>
<h1></h1>
<jsp:useBean id="dao" class="webprj.dao.A05_PreDAO"/>
<jsp:useBean id="sch" class="webprj.z01_vo.Dept"/>
<jsp:setProperty property="*" name="sch"/>
<div class="container">
  <form >
  <div class="row">
    <div class="col-25">
      <label for="dname">부서명</label>
    </div>
    <div class="col-75">
      <input type="text" id="dname" name="dname" placeholder="부서명입력.."
         value="${sch.dname}">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="loc">부서위치</label>
    </div>
    <div class="col-75">
      <input type="text" id="loc" name="loc" placeholder="부서위치입력.."
         value="${sch.loc}">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div> 
<table>
    <tr><th>no</th><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>
    <c:forEach var="dept" items="${dao.getDeptList2(sch)}" varStatus="sts">
    <tr style="background-color:${sts.first?'yellow':''};
                color:${sts.last?'red':''}">
      <td>${sts.count}</td><td>${dept.deptno}</td><td>${dept.dname}</td><td>${dept.loc}</td></tr>
    </c:forEach>
</table>
</body>
</html>