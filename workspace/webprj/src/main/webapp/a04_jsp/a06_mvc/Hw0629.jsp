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
       //$("h1").text("시작!");
    });
</script>
</head>
<!-- 2022-06-29
[1단계:개념] 1. jstl의 날짜와 숫자 형식 처리의 기본 형식을 기술하세요.
[1단계:확인] 2. 회원별로 구매한 물건이 다수개일 때, 아래 형식으로 출력해보세요
         forEach, forTokens 활용
         (Buyer)VO객체 필드 :String name; String blist;
         List<Buyer> blist = new ArrayList<Buyer>();
         blist.add(new Buyer("홍길동","사과&바나나&딸기");
         blist.add(new Buyer("신길동","오렌지&수박");
         blist.add(new Buyer("오길동","딸기&바나나");
         # 출력 #
      홍길동 : 사과, 바나나, 딸기
      신길동 : 오렌지, 수박
      오길동 : 딸기 바나나
[1단계:개념] 3. mvc패턴의 각 model, view, controller 역할을 기술하세요.
[1단계:개념] 4. mvc패턴으로 부서정보의 조회 내용을 출력하세요. -->
<body>
<%-- 

--%>
<%
  List<Buyer> blist = new ArrayList<Buyer>();
  blist.add(new Buyer("홍길동","사과&바나나&딸기"));
  blist.add(new Buyer("신길동","오렌지&수박"));
  blist.add(new Buyer("오길동","딸기&바나나"));
  request.setAttribute("blist",blist);
%>
<h1>물건정보</h1>
<c:forEach var="buyer" items="${blist}">
<h2>${buyer.name} :
	<c:forTokens var="prod" varStatus="sts"
		items="${buyer.plist}" delims="&">
		${prod}<c:if test="${not sts.last}">,</c:if>
	</c:forTokens>
	
	</h2>
</c:forEach>
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