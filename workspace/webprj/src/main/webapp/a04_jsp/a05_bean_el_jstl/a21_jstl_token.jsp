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
# forTokens
1. 데이터가 구분자에 의해서 처리가 필요할 때 사용된다.
2. 속성
  items : 구분자가 있는 문자열
  delims : 구분자
  var : 단위 데이터
--%>
<c:forTokens var="fruit" items="사과&바나나&딸기" delims="&">
<h2>${fruit}</h2>
</c:forTokens>
<%-- ps) 테이블에 하나의 컬럼안에 여러개 데이터를 필요한데, 정규화 과정을 거치기엔 너무 간단한 데이터일 경우,
      불러서, for Tokens으로 사용할 때도 있다.
  ex) --%>
<select name="fruit">
<c:forTokens var="fruit" items="사과&바나나&딸기" delims="&">
  <option>${fruit}</option>
</c:forTokens>
<h1></h1>
<div class="container">
  <form >
  <div class="row">
    <div class="col-25">
      <label for="dname">@@@</label>
    </div>
    <div class="col-75">
      <input type="text" id="dname" name="dname" placeholder="부서명입력.."
         value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div> 
<table>
   <tr><th>###</th><th>###</th><th>##</th></tr>
   <tr><td></td><td></td><td></td></tr>
</table>
</body>
</html>