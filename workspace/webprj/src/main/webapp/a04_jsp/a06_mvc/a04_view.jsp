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
<h3>${model04}
<%-- 

--%>
<h1></h1>
<div class="container">
  <form >
  <div class="row">
    <div class="col-25">
      <label for="pname">물건명</label>
    </div>
    <div class="col-75">
      <input type="text" id="pname" name="pname" placeholder="물건명입력.."
         value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="price">가격</label>
    </div>
    <div class="col-75">
      <input type="text" id="price" name="price" placeholder="가격입력.."
         value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="cnt">갯수</label>
    </div>
    <div class="col-75">
      <input type="text" id="cnt" name="cnt" placeholder="갯수입력.."
         value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div>
</body>
</html>