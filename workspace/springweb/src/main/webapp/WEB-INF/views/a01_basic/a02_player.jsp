<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
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
      // $("h1").text("시작!");
    });
</script>
</head>
<body>
<%-- 

--%>
<h1></h1>
<div class="container">
  <form >
  <div class="row">
    <div class="col-25">
      <label for="pname">운동선수</label>
    </div>
    <div class="col-75">
      <input type="text" id="pname" name="pname" placeholder="이름입력.."
         value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="score">성적</label>
    </div>
    <div class="col-75">
      <input type="text" id="score" name="score" placeholder="성적입력.."
         value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div> 
<table>
   <tr><th>운동선수</th><td>${playerInfo.pname}</td></tr>
   <tr><th>성적</th><td>${playerInfo.score}</td></tr>
</table>
</body>
</html>