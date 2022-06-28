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
# forEach를 이용한 객체형 list 처리
1. 기본형식
    <c:forEach var="단위객체" items="${배열형데이터}" varStatus="sts">
        ${sts.index}, ${단위객체.property}
    </c:>
2. varStatus의 속성
    ${sts.index} : 0부터 시작하는 index값
    ${sts.count} : 1부터 시작하는 count값
    ${sts.first} : 첫번째 값 여부를 나타내는 boolean true/false
    ${sts.last} : 마지막 값 여부를 나타내는 boolean true/false
--%>
<h1></h1>
<jsp:useBean id="dao" class="webprj.dao.A05_PreDAO"/>
<jsp:useBean id="sch" class="webprj.z01_vo.Emp"/>
<jsp:setProperty property="*" name="sch"/>
<div class="container">
  <form >
  <div class="row">
    <div class="col-25">
      <label for="ename">사원명</label>
    </div>
    <div class="col-75">
      <input type="text" id="ename" name="ename" placeholder="사원명입력.."
         value="${sch.ename}">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="job">직책명</label>
    </div>
    <div class="col-75">
      <input type="text" id="job" name="job" placeholder="직책명입력.."
         value="${sch.job}">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div> 
<table>
    <tr><th>no</th><th>사원번호</th><th>사원명</th><th>직책</th></tr>
    <c:forEach var="emp" items="${dao.getEmpList2(sch)}" varStatus="sts">
    <tr style="background-color:${sts.first?'yellow':''};
                color:${sts.last?'red':''}">
      <td>${sts.count}</td><td>${emp.empno}</td><td>${emp.ename}</td><td>${emp.job}</td></tr>
    </c:forEach>
</table>
</body>
</html>